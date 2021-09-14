package phatsmalone.com.Main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import phatsmalone.com.Main.dbModel.DAO;

import java.io.IOException;
import java.sql.SQLException;

public class ProjectController {
    String words;
    @FXML
    private TextField searchBar;
    //observable list for table entry
    @FXML
    private TableView<Item> itemTable;

    @FXML
    private TableColumn<Item, String> name;

    @FXML
    private TableColumn<Item, String> issueNumber;

    @FXML
    private TableColumn<Item, String> date;

    @FXML
    private TableColumn<Item, String> description;

    @FXML
    private TableColumn<Item, Float> price;

    @FXML
    private TableColumn<Item, Integer> rarity;

    //FIXME FINISH THIS
    /*  initialize()
     *
     *  Method is called when fxml file has loaded into memory. Uses lambdas to set values of cells.
     *
     */
    @FXML
    private void initialize() throws SQLException, ClassNotFoundException {
    //in item class, write methods that return the property of the values as objects
    name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    issueNumber.setCellValueFactory(cellData -> cellData.getValue().issueNumProperty());
    date.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
    description.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
    price.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
    rarity.setCellValueFactory((cellData -> cellData.getValue().rarityScaleProperty().asObject()));
    populateGrid(DAO.searchAllItems());
    }
    /*
     *
     *
     *
     */
    @FXML
    private void loadInitItems(){}

    //FIXME fix search result
    /*  searchButton()
    *
    *  The user inputs a keyword in the search bar and will return values
    *  if they exist.
    *
    */
    //grab data from table column
    //populate table with data to test the search feature
    //put the prepare statement in the DAO
    @FXML
    private void searchButton(ActionEvent event) throws IOException, ClassNotFoundException {
        String keyword = searchBar.getText();
        populateGrid( DAO.searchItem(keyword));
    }

    /*
     *
     *
     *
     */
    @FXML
    private void populateItemGrid(Item item) throws ClassNotFoundException{
        ObservableList<Item>  list = FXCollections.observableArrayList();
        list.add(item);
        itemTable.setItems(list);
    }

    /*
     *
     *
     *
     */
    @FXML
    private void populateGrid(ObservableList<Item> items) throws ClassNotFoundException{
        itemTable.setItems(items);
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
    @FXML
    private void setItemToGrid(Item items) {

    }
    /*
     *
     *
     *
     */
    @FXML
    private void populateAndShowItems(Item items) throws ClassNotFoundException{
        if (items != null) {
            populateItemGrid(items);
        }
    }

    @FXML
    private void addButton(ActionEvent event) throws IOException {
        Parent frag = FXMLLoader.load(getClass().getResource("addFragment.fxml"));
        Scene fragScene = new Scene(frag);


        Stage addFragment = new Stage();
        addFragment.setScene(fragScene);
        addFragment.initModality(Modality.WINDOW_MODAL);
        addFragment.initOwner(addFragment.getOwner());
        addFragment.showAndWait();

    }


    @FXML
    private void updateButton(ActionEvent event) {

    }


    @FXML
    private void deleteButton(ActionEvent event) throws IOException {

    }
}
