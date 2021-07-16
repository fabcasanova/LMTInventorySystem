package phatsmalone.com.Main.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import phatsmalone.com.Main.Item;
import phatsmalone.com.Main.dbModel.DAO;
import phatsmalone.com.Main.dbModel.DBConnect;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ProjectController {
    String words;
    @FXML
    private TextField searchBar;
    //observable list for table entry
    @FXML
    private TableView itemTable;

    @FXML
    private TableColumn<Item, String> name;

    @FXML
    private TableColumn<Item, String> issueNumber;

    @FXML
    private TableColumn<Item, Date> date;

    @FXML
    private TableColumn<Item, String> description;

    @FXML
    private TableColumn<Item, Float> price;

    @FXML
    private TableColumn<Item, Integer> rarity;


    /*  initialize()
     *
     *  Method is called when fxml file has loaded into memory. Uses lambdas to set values of cells.
     *
     */
    @FXML
    private void initialize() {
    //in item class, write methods that return the property of the values as objects
    name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    issueNumber.setCellValueFactory(cellData ->cellData.getValue().issueNumProperty());
    date.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
    }



    /*  searchButton()
    *
    *  The user inputs a keyword in the search bar and will return values
    *  if they exist.
    *
    */
    //grab data from textarea
    //grab data from table column
    //populate table with data to test the search feature
    //put the prepare statement in the DAO
    @FXML
    private void searchButton(ActionEvent event) throws IOException, SQLException {
    String keyword = searchBar.getText();
    String table = "";
    DAO dao = new DAO();
    //dao.searchKeyWord(keyword, table);
    //populate observable list with entries from user keyword if any
    }




    /*
     *
     *
     *
     */



    @FXML
    private void addButton(ActionEvent event) throws IOException {

    }


    @FXML
    private void updateButton(ActionEvent event) {

    }


    @FXML
    private void deleteButton(ActionEvent event) throws IOException {

    }
}
