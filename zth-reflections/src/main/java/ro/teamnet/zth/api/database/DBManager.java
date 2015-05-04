package ro.teamnet.zth.api.database;

import java.sql.*;

import static ro.teamnet.zth.api.database.DBManager.getConnection;

/**
 * Created by rares on 4/29/2015.
 */
public class DBManager {
    public DBManager() throws UnsupportedOperationException{

    }
    public static final String CONNECTION_STRING = ("jdbc:mysql://" + DProperties.IP + "/" + DProperties.SCHEMA);

    private static void registerDriver() throws ClassNotFoundException {
        Class.forName(DProperties.DRIVER_CLASS);
    }
    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        registerDriver();
        Connection conn = DriverManager.getConnection(CONNECTION_STRING, DProperties.USER, DProperties.PASS);

        return conn;
    }
    public static boolean checkConnection() throws SQLException, ClassNotFoundException {

        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT 1");
        if (rs.next()) {
            return (rs.getInt(1) == 1);
        }
        return false;
    }
}
