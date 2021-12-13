package Model.JDBCConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

public class JDBCConnection {

    private Connection con;
    private Statement stmt;

    public JDBCConnection() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/RMS","root","umut1234");

            this.stmt=con.createStatement();
        }catch(Exception e){ System.out.println(e);}
    }

    public Connection getCon() {
        return this.con;
    }

    public Statement getStmt() {
        return this.stmt;
    }

}
