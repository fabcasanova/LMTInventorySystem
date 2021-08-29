package phatsmalone.com.Main.dbModel;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
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

    /*  executeDBQuery()
     *
     *  Creates resultsets for requested sql statements.
     *
     */
    public static ResultSet executeDBQuery(String qryStatement) throws SQLException {

        Statement statement = null;
        ResultSet set = null;
        CachedRowSet crs = null;
        try{
            connect();

            //System.out.println( "Select Statement :    " + qryStatement + "\n");
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

    /*  executeDBUpdate()
     *
     *  Executes updates into the database.
     *
     */
    public static void executeDBUpdate(String sqlString) throws SQLException{
        PreparedStatement statement = null;
        try {
            connect();
            statement = connect.prepareStatement(sqlString);
            statement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            dbDisconnect();
        }
    }
}
