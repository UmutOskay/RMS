package Model.Services;


import Model.Encryption.Salter;
import Model.JDBCConnection.JDBCConnection;

import java.sql.*;

public class LoginService {

    private JDBCConnection jdbc_conn;
    private Connection conn;
    private Statement stmt;

    public LoginService(){
        this.jdbc_conn = new JDBCConnection();
        this.conn = jdbc_conn.getCon();
        this.stmt = jdbc_conn.getStmt();
    }

    // Below method returns -1 if user does not exist, returns 0 if user exists and is admin, returns 1 if user exists and not admin
    public int validate_user(String faculty_id, String password) throws SQLException {
        password = Salter.salt(password, "RMS");
        faculty_id = faculty_id.toUpperCase();
        PreparedStatement stmt = this.conn.prepareStatement("select is_admin from user where faculty_id=? and user_password=?");
        stmt.setString(1, faculty_id);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        if(rs.next()) {
            if(rs.getBoolean(1)) return 0;
            else return 1;
        }
        return -1;
    }

    public int is_admin(String faculty_id) throws SQLException {
        faculty_id = faculty_id.toUpperCase();
        PreparedStatement stmt = this.conn.prepareStatement("select is_admin from user where faculty_id=?");
        stmt.setString(1, faculty_id);
        ResultSet rs = stmt.executeQuery();
        if(rs.next()) {
            if(rs.getBoolean(1)) return 1;
            else return 0;
        }
        return -1;
    }

}
