package Model.Services;

import Model.JDBCConnection.JDBCConnection;

import java.sql.*;

public class UpdateService {

    private JDBCConnection jdbc_conn;
    private Connection conn;
    private Statement stmt;

    public UpdateService() {
        this.jdbc_conn = new JDBCConnection();
        this.conn = jdbc_conn.getCon();
        this.stmt = jdbc_conn.getStmt();
    }

    // When a user reserves a room, room availability information shall change. SRS-RMS-001.2
    // RMS shall enable admins to make reservations on behalf of the users. SRS-RMS-007.3
    // RMS shall not allow users that are banned by the admin to make reservations for a week. SRS-RMS-008.1 TODO LATER


    public int reservation(String student_id, int room_id, String time_slot) throws SQLException {
        PreparedStatement stmt = this.conn.prepareStatement("select * from reservations where room_id=? and time_slot=?;");
        stmt.setInt(1, room_id);
        stmt.setString(2, time_slot);
        ResultSet rs = stmt.executeQuery();
        if(rs.next()){
            System.out.println("Room is already reserved");
            return -1; // -1 means room is already reserved. SRS-RMS-003.1
        }
        stmt = this.conn.prepareStatement("select * from reservations where student_id=? and time_slot=?;");
        stmt.setString(1, student_id);
        stmt.setString(2, time_slot);
        rs = stmt.executeQuery();
        if(rs.next()){
            System.out.println("User has already reserved a room in same time slot");
            return -2; // -2 means user has already reserved a room in same time slot. SRS-RMS-006.1
        }

        stmt = this.conn.prepareStatement("select time_slots_left from user where faculty_id=?;");
        stmt.setString(1, student_id);
        rs = stmt.executeQuery();
        if(rs.next()){
            if(rs.getInt(1) == 0) {
                System.out.println("User has already reserved for 3 hours.");
                return -3; // -3 means user has already reserved for 3 hours. SRS-RMS-006.2
            }
        }

        // Insert reservation information to reservation table.
        stmt = this.conn.prepareStatement("insert into reservations values (?, ?, ?)");
        stmt.setString(1, student_id);
        stmt.setInt(2, room_id);
        stmt.setString(3, time_slot);
        stmt.executeUpdate();
        System.out.println("Room is reserved");


        // When a user makes X hours reservation, the possible reservation hour can be made by the user shall decrease by X hour. SRS-RMS-005.1
        stmt = this.conn.prepareStatement("update user set time_slots_left=time_slots_left-1 where faculty_id=?");
        stmt.setString(1, student_id);
        stmt.executeUpdate();



        /*stmt = this.conn.prepareStatement("select * from user where faculty_id=?");
        stmt.setString(1, student_id);
        rs = stmt.executeQuery();
        rs.next();
        System.out.println(rs.getInt(7));*/



        return 0; // 0 means reservation is successful. SRS-RMS-002.1
    }

}
