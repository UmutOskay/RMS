package Model.Services;


import Model.Encryption.Salter;
import Model.JDBCConnection.JDBCConnection;
import Model.Object.Reservation;
import Model.Object.Room;
import Model.Object.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DisplayService {

    private JDBCConnection jdbc_conn;
    private Connection conn;
    private Statement stmt;

    public DisplayService() {
        this.jdbc_conn = new JDBCConnection();
        this.conn = jdbc_conn.getCon();
        this.stmt = jdbc_conn.getStmt();
    }

    public ArrayList<User> displayUser() throws SQLException{
        ArrayList<User> users = new ArrayList<>();
        PreparedStatement stmt = this.conn.prepareStatement("select faculty_id, user_fullname from user;");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            User user = new User();
            user.setFaculty_id(rs.getString(1));
            user.setUser_full_name(rs.getString(2));
            users.add(user);
        }
        return users;
    }

    public ArrayList<Room> displayRoom() throws SQLException {
        ArrayList<Room> rooms = new ArrayList<>();
        PreparedStatement stmt = this.conn.prepareStatement("select * from room;");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            Room room = new Room();
            room.setRoom_id(rs.getInt(1));
            room.setRoom_location(rs.getString(2));
            room.setIs_available_at_08(rs.getBoolean(3));
            room.setIs_available_at_09(rs.getBoolean(4));
            room.setIs_available_at_10(rs.getBoolean(5));
            room.setIs_available_at_11(rs.getBoolean(6));
            room.setIs_available_at_12(rs.getBoolean(7));
            room.setIs_available_at_13(rs.getBoolean(8));
            room.setIs_available_at_14(rs.getBoolean(9));
            room.setIs_available_at_15(rs.getBoolean(10));
            room.setIs_available_at_16(rs.getBoolean(11));
            room.setIs_available_at_17(rs.getBoolean(12));
            rooms.add(room);
        }
        return rooms;
    }

    public ArrayList<Reservation> displayReservations() throws SQLException {
        ArrayList<Reservation> reservations = new ArrayList<>();
        PreparedStatement stmt = this.conn.prepareStatement("select * from reservations;");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            Reservation reservation = new Reservation();
            reservation.setStudent_id(rs.getString(1));
            reservation.setRoom_id(rs.getInt(2));
            reservation.setTime_slot(rs.getString(3));
            reservations.add(reservation);
        }
        return reservations;
    }
    public ArrayList<Reservation> displayUserReservations(String faculty_id) throws SQLException{
        ArrayList<Reservation> userReservations = new ArrayList<>();
        PreparedStatement stmt = this.conn.prepareStatement("select room_id,time_slot from reservations where faculty_id=?;");
        stmt.setString(1,faculty_id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            Reservation reservation = new Reservation();
            reservation.setRoom_id(rs.getInt(1));
            reservation.setTime_slot(rs.getString(2));
            userReservations.add(reservation);
        }
        return userReservations;
    }
}
