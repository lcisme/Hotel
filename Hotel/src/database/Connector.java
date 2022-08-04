package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Connector {
    public final static String connectionString="jdbc:mysql://localhost:3306/hotel";
    public final static String user = "root";
    public final static String password = "";

    private static Connector instance;
    private Connection conn;
    private Connector() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        // tao connect
        conn = DriverManager.getConnection(connectionString,user,password);
    }

    public static Connector getInstance() throws Exception {
        if (instance == null){
            instance = new Connector();
        }
        return instance;
    }


    public PreparedStatement getStatement(String sql) throws Exception{
        PreparedStatement statement = conn.prepareStatement(sql);
        return statement;
    }
}
