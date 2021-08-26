package phatsmalone.com.Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
        System.out.println(name);
        item.setName(name);
        issue = issueField.getText();
        System.out.println(issue);
        item.setIssueNumber(issue);
        releaseDate = releaseDateField.getText();
        System.out.println(releaseDate);
        item.setDate(releaseDate);
        description = descriptionField.getText();
        System.out.println(description);
        item.setDescription(description);
        priceString = priceField.getText();
        System.out.println(priceString);
        Float price = Float.parseFloat(priceString);
        item.setPrice(price);
        rarityString = rarityField.toString();
        System.out.println(rarityString);
        Integer rarity = Integer.parseInt(rarityString);
        item.setRarityScale(rarity);


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
