package Model.Services;


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


    public boolean validate_user() throws SQLException {
        ResultSet rs = this.stmt.executeQuery("select faculty_id from user");
        while(rs.next())
            System.out.println(rs.getString(1));
        return true;
    }


}
