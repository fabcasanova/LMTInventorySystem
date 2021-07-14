package phatsmalone.com.Main.dbModel;

import com.sun.rowset.CachedRowSetImpl;
import java.io.IOException;
import java.sql.*;


public class DBConnect {

    public static Connection connect = null;
    /*  connect()
     *
     *  makes initial connection to lmt database
     *
     */
    public static void connect() {

        try {
            Class.forName("org.sqlite.JDBC");
            String connectionURL = "jdbc:sqlite:lmt.sqlite";
            connect = DriverManager.getConnection(connectionURL);
            System.out.println("Connection: lmt.sqlite");
            //return connect;

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
        //return null;
    }
    //FIXME FINISH THIS
    public static ResultSet executeDBQuery(String qryStatement) {

        Statement statement = null;
        ResultSet set = null;
        CachedRowSetImpl crs = null;
        try{
            connect();
            statement =
        } catch (Exception e) {}

        return crs;
    }


}
