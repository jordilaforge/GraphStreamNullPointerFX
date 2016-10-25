package main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private Button dialogOpen;

    @FXML
    public void dialogOpenButtonPressed() throws IOException {
        System.out.println("button pressed");
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../dialog/Dialog.fxml"));
        stage.setTitle("Add new entry");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }
}
