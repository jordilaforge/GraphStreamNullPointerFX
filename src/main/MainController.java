package main;

import dialog.DialogController;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class MainController {

    @FXML
    private Button dialogOpen;

    @FXML
    public void dialogOpenButtonPressed() throws IOException {
        System.out.println("button pressed");
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        Pane p = fxmlLoader.load(getClass().getResource("../dialog/Dialog.fxml").openStream());
        final DialogController dialogController = (DialogController) fxmlLoader.getController();
        final Parent root = FXMLLoader.load(getClass().getResource("../dialog/Dialog.fxml"));
        stage.setTitle("Add new entry");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                dialogController.closeViewer();
            }
        });
    }


}
