package phatsmalone.com.Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import phatsmalone.com.Main.dbModel.DAO;

public class AddItemFragmentController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField issueField;
    @FXML
    private TextField releaseDateField;
    @FXML
    private TextArea descriptionField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField rarityField;
    @FXML
    private Button addButton;
    @FXML
    private Button exitButton;

    //FIXME TRY CATCH DATA
    /*  addButtonEntered()
     *
     *  This action event sends an item to the dao after it is pressed.
     *
     */
    @FXML
    private void addButtonEntered(ActionEvent event){

        String name;
        String issue;
        String releaseDate;
        String description;
        String priceString;
        String rarityString;
        Item item = new Item();

        name = nameField.getText();
        item.setName(name);
        issue = issueField.getText();
        item.setIssueNumber(issue);
        releaseDate = releaseDateField.getText();
        item.setDate(releaseDate);
        description = descriptionField.getText();
        item.setDescription(description);
        priceString = priceField.getText();
        Float price = Float.parseFloat(priceString);
        item.setPrice(price);
        rarityString = rarityField.getText();
        Integer rarity = Integer.parseInt(rarityString);
        item.setRarityScale(rarity);

        DAO dao = new DAO();
        DAO.addItem(item);

        Stage stage = (Stage) addButton.getScene().getWindow();
        stage.close();
    }

    /*  CancelButtonEntered()
     *
     *  This action event cancels the add item procedure and closes the window.
     *
     */
    @FXML
    private void exitButtonEntered(ActionEvent event){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

}
