package phatsmalone.com.Main.dbModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import phatsmalone.com.Main.Item;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {




    /*  getItemFromResultSet()
     *
     *  Uses resultset from database.  It then sets and returns an item object.
     *
     */
    public Item getItemFromResultSet(ResultSet set) throws SQLException{
        Item item = null;

        if (set.next()) {
            item = new Item();
            item.setName(set.getString("Name"));
            item.setIssueNumber(set.getString("IssueNumber"));
            item.setDate(set.getDate("Date"));
            item.setDescription(set.getString("Description"));
            item.setPrice(set.getFloat("Price"));
            item.setRarityScale(set.getInt("RarityScale"));
        }

        return item;
    }

    /*  getItemList()
     *
     *  retrieves and populates data itemlist on project page
     *
     */
    public static ObservableList<Item> getItemList(ResultSet set) throws SQLException, ClassNotFoundException {

        ObservableList<Item> itemList = FXCollections.observableArrayList();
        Item item = null;

        while (set.next()) {

            item = new Item();
            item.setName(set.getString("Name"));

            System.out.println(set.getString("Name"));

            item.setIssueNumber(set.getString("IssueNumber"));
            item.setDate(set.getDate("Date"));
            item.setDescription(set.getString("Description"));
            item.setPrice(set.getFloat("Price"));
            item.setRarityScale(set.getInt("RarityScale"));
            itemList.add(item);

        }

        return itemList;
    }

    /*
     *
     *
     *
     */
    public static ObservableList<Item> searchAllItems() throws SQLException, ClassNotFoundException {
        String statement = "SELECT * FROM ItemInventory";

        try{
            ResultSet itemResult = DBConnect.executeDBQuery(statement);
            return getItemList(itemResult);
        } catch(SQLException e) {
            System.out.println("Search Unsuccessful");
            throw e;
        }
    }
    //fix search
    /*  searchKeyword
     *
     *  This method executes the search function and returns the keywords row
     *
     */
     /* public void searchKeyWord(String keyword, String table) throws SQLException {
        PreparedStatement statement;
        DBConnect con = new DBConnect();
        statement = con.connect.prepareStatement("SELECT * FROM " + table + " WHERE " + table + " MATCH = " + keyword);
        ResultSet set = statement.executeQuery();
        String search;

        Item item = null;

        while (set.next()) {

            item = new Item();
            item.setName(set.getString("Name"));
            item.setIssueNumber(set.getString("IssueNumber"));
            item.setDate(set.getDate("Date"));
            item.setDescription(set.getString("Description"));
            item.setPrice(set.getFloat("Price"));
            item.setRarityScale(set.getInt("RarityScale"));
        }

        System.out.println("search");
    }
    */
}