package Model.Services;


import Model.Encryption.Salter;
import Model.JDBCConnection.JDBCConnection;

import java.sql.*;

public class LoginService {

    private JDBCConnection jdbc_conn;
    private Connection conn;
    private Statement stmt;
    private Salter salter;

    public LoginService(){
        this.jdbc_conn = new JDBCConnection();
        this.conn = jdbc_conn.getCon();
        this.stmt = jdbc_conn.getStmt();
    }


    public boolean validate_user(String username, String password) throws SQLException {
        password = Salter.salt(password, "RMS");
        ResultSet rs = this.stmt.executeQuery("select faculty_id from user");
        while(rs.next())
            System.out.println(rs.getString(1));
        return true;
    }


}
