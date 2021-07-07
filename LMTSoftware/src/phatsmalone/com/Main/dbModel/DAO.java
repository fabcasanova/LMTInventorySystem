package phatsmalone.com.Main.dbModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {



    /*  searchKeyword
     *
     *  This method executes the search function and returns the keywords row
     *
     */
    public void searchKeyWord(String keyword, String table) throws SQLException {
        PreparedStatement statement;
        DBConnect con = new DBConnect();
        statement = con.connect.prepareStatement("SELECT * FROM " + table + " WHERE " + table + " MATCH = " + keyword);
        ResultSet set = statement.executeQuery();
        String search;

        while(set.next()) {
            search = set.getString(1);
        }

        System.out.println("search");
    }
}
