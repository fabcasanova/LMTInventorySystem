package phatsmalone.com.Main;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    protected Stage window;

@FXML
private void NewProject(ActionEvent event) throws IOException {
    Parent menuScene = FXMLLoader.load(getClass().getResource("NewProject.fxml"));
    Scene newProjectScene = new Scene(menuScene);
    window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(newProjectScene);
    window.show();
};

@FXML
private void OpenProject(ActionEvent event) throws IOException{
    Parent openScene = FXMLLoader.load(getClass().getResource("OpenProject.fxml"));
    Scene oProjectScene = new Scene(openScene);
    window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    window.setScene(oProjectScene);
    window.show();
};

@FXML
private void ExitProject(ActionEvent event) throws IOException{
    Platform.exit();
};

@FXML
private void NextButton(ActionEvent event) throws IOException{
    Parent projectScene = FXMLLoader.load(getClass().getResource("ProjectMenu.fxml"));
    Scene nProject = new Scene(projectScene);
    window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    window.setScene(nProject);
    window.show();
};

@FXML
private  void BackButton(ActionEvent event) throws IOException{
    Parent startScene = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
    Scene mainMenuScene = new Scene(startScene);
    window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    window.setScene(mainMenuScene);
    window.show();
};
}
