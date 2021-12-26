package test;

import Model.JDBCConnection.JDBCConnection;
import Model.Object.User;
import Model.Services.DisplayService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;

class DisplayServiceTest {

    private JDBCConnection jdbc_conn;
    private Connection conn;
    private Statement stmt;
    private DisplayService ds;

    public DisplayServiceTest() {
        this.jdbc_conn = new JDBCConnection();
        this.conn = jdbc_conn.getCon();
        this.stmt = jdbc_conn.getStmt();
        this.ds = new DisplayService();
    }

    @Test
    void displayUser() throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        PreparedStatement stmt = this.conn.prepareStatement("select faculty_id, user_fullname from user;");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            User user = new User();
            user.setFaculty_id(rs.getString(1));
            user.setUser_full_name(rs.getString(2));
            users.add(user);
        }
        for(int i = 0; i < users.size(); i++){
            Assertions.assertEquals(users.get(i).getFaculty_id(), ds.displayUser().get(i).getFaculty_id());
            Assertions.assertEquals(users.get(i).getUser_full_name(), ds.displayUser().get(i).getUser_full_name());
            Assertions.assertEquals(users.get(i).getUser_mail(), ds.displayUser().get(i).getUser_mail());
            Assertions.assertEquals(users.get(i).isIs_admin(), ds.displayUser().get(i).isIs_admin());
            Assertions.assertEquals(users.get(i).isIs_banned(), ds.displayUser().get(i).isIs_banned());
            Assertions.assertEquals(users.get(i).getLeft_slots(), ds.displayUser().get(i).getLeft_slots());
            Assertions.assertEquals(users.get(i).getBanned_until(), ds.displayUser().get(i).getBanned_until());
        }

    }

    @Test
    void displayRoom() {
    }

    @Test
    void displayReservations() {
    }

    @Test
    void displayUserReservations() {
    }
}