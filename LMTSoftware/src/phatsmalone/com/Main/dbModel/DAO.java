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
            item.setDate(set.getString("ReleaseDate"));
            item.setDescription(set.getString("Description"));
            item.setPrice(set.getFloat("Price"));
            item.setRarityScale(set.getInt("RarityScale"));
        }

        return item;
    }

    /*  getItemList()
     *
     *  Retrieves and populates data itemlist on project page.
     *
     */
    public static ObservableList<Item> getItemList(ResultSet set) throws SQLException, ClassNotFoundException {

        ObservableList<Item> itemList = FXCollections.observableArrayList();


        while (set.next()) {

            Item item = new Item();
            item.setName(set.getString("Name"));
            //System.out.println(set.getString("Name"));

            item.setIssueNumber(set.getString("IssueNumber"));
            //System.out.println(set.getString("IssueNumber"));
            //FIXME CONVERT SQL Date into a Java Object then set it.


            item.setDate(set.getString("ReleaseDate"));
            //System.out.println(set.getString("Date"));

            item.setDescription(set.getString("Description"));
            //System.out.println(set.getString("Description"));

            item.setPrice(set.getFloat("Price"));
            //System.out.println(set.getString("Price"));

            item.setRarityScale(set.getInt("RarityScale"));
            //System.out.println(set.getString("RarityScale"));

            itemList.add(item);

        }

        return itemList;
    }

    /* searchAllItems()
     *
     *  This method generates the sql string to get the
     *  data for the starting menu in the project page.
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
    //FIXME Test for duplicates.
    /*  searchItem()
     *
     *  This method executes the search function and returns the keywords row
     *
     */
    public static ObservableList<Item> searchItem(String keyword) {
        String  statement = "SELECT * FROM search WHERE search MATCH '" + keyword + "'";
        try {
            DBConnect.virtualSearchTable();

            ResultSet itemResult = DBConnect.executeDBQuery(statement);
            return getItemList(itemResult);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    /*  addItem()
     *
     *  This method adds an item to the database. Sends sql statement to DBConnect.
     *
     */
    public static void addItem(Item item) {
        String statement =  "INSERT INTO ItemInventory(Name, IssueNumber, ReleaseDate, Description, Price, RarityScale)" +
                            " VALUES(?, ?, ?, ?, ?, ?);";
        try {
            DBConnect.executeDBInsert(statement, item);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //FIXME NEEDS TO BE TESTED
    /*  deleteItemRow()
     *
     *  This method gets called from the project menu delete button. Acts as the Data
     *  Object that interacts with the db connection.  Generates the delete sql statement to
     *  delete the selected item in the db.
     */
    public static void deleteItemRow(Item item) {
        String statement = "DELETE FROM ItemInventory WHERE Name = " + item.getName() +
                " AND IssueNumber = " + item.getIssueNumber();
        try {
            DBConnect.executeDelete(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     *
     *
     *
     */
    public static void updateItem() {
        String statement = "SELECT * FROM ItemInventory";
        try {
            DBConnect.executeDBQuery(statement);
        } catch (SQLException e)  {
            e.printStackTrace();
        }
    }


}
