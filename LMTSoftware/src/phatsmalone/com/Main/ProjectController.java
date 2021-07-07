package phatsmalone.com.Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import phatsmalone.com.Main.dbModel.DAO;
import phatsmalone.com.Main.dbModel.DBConnect;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectController {
    String words;
    @FXML
    private TextField searchBar;
    //observable list for table entry
    @FXML
    private ListView<String> listView;


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
    dao.searchKeyWord(keyword, table);
    //populate observable list with entries from user keyword if any
    }


    /*
    *
    *
    *
    */


    /*
    *
    *
    *
    */



    /*
    *
    *
    *
    */
    @FXML
    private void addButton(ActionEvent event) throws IOException {

    }

    /*
    *
    *
    *
    */
    @FXML
    private void updateButton(ActionEvent event) {

    }

    /*
    *
    *
    *
    */
    @FXML
    private void deleteButton(ActionEvent event) throws IOException {

    }
}
