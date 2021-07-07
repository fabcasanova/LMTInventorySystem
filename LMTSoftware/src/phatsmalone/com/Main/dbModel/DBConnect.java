package phatsmalone.com.Main.dbModel;

import java.io.IOException;
import java.sql.*;


public class DBConnect {
    public Connection connect = null;

    /*
     *
     *
     *
     */
    public Connection connect() {

        try {
            Class.forName("org.sqlite.JDBC");
            String connectionURL = "jdbc:sqlite:lmt.sqlite";
            connect = DriverManager.getConnection(connectionURL);
            System.out.println("Connection: lmt.sqlite");
            return connect;

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection: N/A");
            e.printStackTrace();
        } finally {
            try {
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }



}
