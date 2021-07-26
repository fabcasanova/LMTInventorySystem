package phatsmalone.com.Main.dbModel;

import com.sun.rowset.*;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
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
            String connectionURL = "jdbc:sqlite:C:\\Users\\PhatsMalone\\LMTManagementSystem\\LMTSoftware\\src\\phatsmalone\\com\\Main\\lmt.sqlite";
            connect = DriverManager.getConnection(connectionURL);
            System.out.println("Connection:  " + connect.toString());


            String sql = "SELECT Name FROM ItemInventory";

            /*try (
                 Statement stmt  = connect.createStatement();
                 ResultSet rs    = stmt.executeQuery(sql)) {

                // loop through the result set
                while (rs.next()) {
                    System.out.println(
                            rs.getString("Name"));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            */
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection: N/A");
            e.printStackTrace();
        }
    }

    /*
     *
     *
     *
     */
    public static void dbDisconnect() throws SQLException{
        try {
            if (connect != null && !connect.isClosed()) {
                connect.close();
            }
        } catch(SQLException e) {
            throw e;
        }
    }

    /*
     *
     *
     *
     */
    public static ResultSet executeDBQuery(String qryStatement) throws SQLException, ClassNotFoundException {

        Statement statement = null;
        ResultSet set = null;
        CachedRowSet crs = null;
        //FIXME DATA NOT RETRIEVING cachedrowset not working, data not showing GO TO GETITEMLIST
        try{
            connect();

            System.out.println( "Select Statement :    " + qryStatement + "\n");
            statement = connect.createStatement();
            set = statement.executeQuery(qryStatement);
            crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.populate(set);
        } catch (Exception e) {
            System.out.println("Data Retrieval Error : " + e);
        } finally {
            if (set != null) {
                set.close();
            }

            if (statement != null) {
                statement.close();
            }
            dbDisconnect();
        }


        return crs;
    }


}
