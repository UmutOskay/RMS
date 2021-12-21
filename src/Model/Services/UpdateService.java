package Model.Services;

import Model.JDBCConnection.JDBCConnection;
import Model.Mail.MailService;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;

public class UpdateService {

    private JDBCConnection jdbc_conn;
    private Connection conn;
    private Statement stmt;
    private MailService ms;
    private Session session;

    public UpdateService() {
        this.jdbc_conn = new JDBCConnection();
        this.conn = jdbc_conn.getCon();
        this.stmt = jdbc_conn.getStmt();
        this.ms = new MailService();
        this.session = ms.getSession();
    }

    // When a user reserves a room, room availability information shall change. SRS-RMS-001.2
    // RMS shall enable admins to make reservations on behalf of the users. SRS-RMS-007.3
    // RMS shall not allow users that are banned by the admin to make reservations for a week. SRS-RMS-008.1 TODO LATER


    public int reservation(String faculty_id, int room_id, String time_slot) throws SQLException {
        PreparedStatement stmt = this.conn.prepareStatement("select user_mail from user where faculty_id=?");
        stmt.setString(1, faculty_id);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        String user_mail = rs.getString(1);

        stmt = this.conn.prepareStatement("select * from reservations where room_id=? and time_slot=?;");
        stmt.setInt(1, room_id);
        stmt.setString(2, time_slot);
        rs = stmt.executeQuery();
        if(rs.next()){
            System.out.println("Room is already reserved");
            return -1; // -1 means room is already reserved. SRS-RMS-003.1
        }
        stmt = this.conn.prepareStatement("select * from reservations where faculty_id=? and time_slot=?;");
        stmt.setString(1, faculty_id);
        stmt.setString(2, time_slot);
        rs = stmt.executeQuery();
        if(rs.next()){
            System.out.println("User has already reserved a room in same time slot");
            return -2; // -2 means user has already reserved a room in same time slot. SRS-RMS-006.1
        }

        stmt = this.conn.prepareStatement("select time_slots_left from user where faculty_id=?;");
        stmt.setString(1, faculty_id);
        rs = stmt.executeQuery();
        if(rs.next()){
            if(rs.getInt(1) == 0) {
                System.out.println("User has already reserved for 3 hours.");
                return -3; // -3 means user has already reserved for 3 hours. SRS-RMS-006.2
            }
        }


        // Insert reservation information to reservation table.
        stmt = this.conn.prepareStatement("insert into reservations values (?, ?, ?, ?, ?)");
        
        Timestamp reservation_time = new Timestamp(System.currentTimeMillis());
        Timestamp reservation_is_at = new Timestamp(System.currentTimeMillis()); // FROM UTC 0, we are at 3

        String reservation_hour = "";
        String[] arr_of_time_slot = time_slot.split("-", 0);

        reservation_hour = arr_of_time_slot[0];
        int int_reservation_hour = Integer.parseInt(reservation_hour);
        reservation_is_at.setHours(int_reservation_hour);
        reservation_is_at.setMinutes(0); // GET FROM STRING TIMESLOT
        reservation_is_at.setSeconds(0); // GET FROM STRING TIMESLOT

        stmt.setString(1, faculty_id);
        stmt.setInt(2, room_id);
        stmt.setString(3, time_slot);
        stmt.setObject(4,reservation_time);
        stmt.setObject(5,reservation_is_at);
        stmt.executeUpdate();
        System.out.println("Room is reserved");

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress("rmsinfo724@gmail.com"));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(user_mail));

            // Set Subject: header field
            message.setSubject("Room Reservation");

            // Now set the actual message
            message.setText("Your room has been reserved");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }


        // When a user makes X hours reservation, the possible reservation hour can be made by the user shall decrease by X hour. SRS-RMS-005.1
        stmt = this.conn.prepareStatement("update user set time_slots_left=time_slots_left-1 where faculty_id=?");
        stmt.setString(1, faculty_id);
        stmt.executeUpdate();

        String time_slot_to_remove = "";
        arr_of_time_slot = time_slot.split("-", 0);

        if(arr_of_time_slot[0].length() == 1) time_slot_to_remove += "0" + arr_of_time_slot[0];
        else time_slot_to_remove = arr_of_time_slot[0];

        time_slot_to_remove = "is_available_at_" + time_slot_to_remove;

        stmt = this.conn.prepareStatement("update room set " + time_slot_to_remove  + "= False where room_id=?" );
        stmt.setInt(1, room_id);
        stmt.executeUpdate();
        // did not change room information yet


        return 0; // 0 means reservation is successful. SRS-RMS-002.1
    }
    public int cancellation(String student_id, int room_id, String time_slot) throws SQLException{
        PreparedStatement stmt = this.conn.prepareStatement("select user_mail from user where faculty_id=?");
        stmt.setString(1, student_id);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        String user_mail = rs.getString(1);

        stmt = this.conn.prepareStatement("select * from reservations where room_id=? and time_slot=?;");
        stmt.setInt(1, room_id);
        stmt.setString(2, time_slot);

        rs = stmt.executeQuery();
        if(rs.next()) {
            Timestamp time_of_reservation = rs.getObject(4,Timestamp.class);
            Timestamp reservation_timeslot = rs.getObject(5,Timestamp.class);
            OffsetDateTime odt = OffsetDateTime.now();
            Timestamp now = new Timestamp(System.currentTimeMillis());;
            System.out.println();

            System.out.println(reservation_timeslot);
            int hour = reservation_timeslot.getHours();
            reservation_timeslot.setHours(hour + 100); // -1
            System.out.println(reservation_timeslot);

            if( now.before(reservation_timeslot) ) {

                stmt = this.conn.prepareStatement("delete from reservations WHERE faculty_id =? and room_id=? and time_slot=?");
                stmt.setString(1, student_id);
                stmt.setInt(2, room_id);
                stmt.setString(3, time_slot);

                stmt.executeUpdate();

                stmt = this.conn.prepareStatement("update user set time_slots_left=time_slots_left+1 where faculty_id=?");
                stmt.setString(1, student_id);
                stmt.executeUpdate();


                String time_slot_to_remove = "";
                String[] arr_of_time_slot = time_slot.split("-", 0);

                if(arr_of_time_slot[0].length() == 1) time_slot_to_remove += "0" + arr_of_time_slot[0];
                else time_slot_to_remove = arr_of_time_slot[0];

                time_slot_to_remove = "is_available_at_" + time_slot_to_remove;

                stmt = this.conn.prepareStatement("update room set " + time_slot_to_remove  + "= TRUE where room_id=?" );
                stmt.setInt(1, room_id);
                stmt.executeUpdate();


                System.out.println("cancellation is accepted.");

                try {
                    // Create a default MimeMessage object.
                    MimeMessage message = new MimeMessage(session);

                    // Set From: header field of the header.
                    message.setFrom(new InternetAddress("rmsinfo724@gmail.com"));

                    // Set To: header field of the header.
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(user_mail));

                    // Set Subject: header field
                    message.setSubject("Room Reservation Cancel");

                    // Now set the actual message
                    message.setText("Your reservation is cancelled");

                    System.out.println("sending...");
                    // Send message
                    Transport.send(message);
                    System.out.println("Sent message successfully....");
                } catch (MessagingException mex) {
                    mex.printStackTrace();
                }

            }
            else{
                System.out.println("There is less than one hours before the reservation. Cancel order is rejected");
                return -1; // -1 means There is less than one hours before the reservation
            }
        }

        else{
            System.out.println("User has not made a reservation");
            return -2; // -2 means no reservation
        }
        // TODO
        System.out.println("cancellation is done");
        return 0; // means cancellation is submitted
    }

    public int banUser(String faculty_id){
        
    }
}
