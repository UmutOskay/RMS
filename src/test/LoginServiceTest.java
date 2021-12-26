package test;

import Model.Encryption.Salter;
import Model.JDBCConnection.JDBCConnection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class LoginServiceTest {

    private JDBCConnection jdbc_conn;
    private Connection conn;
    private Statement stmt;

    public LoginServiceTest() {
        this.jdbc_conn = new JDBCConnection();
        this.conn = jdbc_conn.getCon();
        this.stmt = jdbc_conn.getStmt();
    }

    @Test
    void validate_user() throws SQLException {
        String password = Salter.salt("admin1234", "RMS");
        String faculty_id = "S017812";
        PreparedStatement stmt = this.conn.prepareStatement("select is_admin from user where faculty_id=? and user_password=?");
        stmt.setString(1, faculty_id);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        if(rs.next()) assertTrue(rs.getBoolean(1));
        else Assertions.assertFalse(rs.getBoolean(1));

        password = Salter.salt("user2234", "RMS");
        faculty_id = "S017815";
        stmt = this.conn.prepareStatement("select is_admin from user where faculty_id=? and user_password=?");
        stmt.setString(1, faculty_id);
        stmt.setString(2, password);
        rs = stmt.executeQuery();
        if(rs.next()) assertFalse(rs.getBoolean(1));
        else Assertions.assertTrue(rs.getBoolean(1));
    }


}