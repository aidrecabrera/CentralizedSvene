package home;

import animatefx.animation.FadeIn;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ExceptionsController {

    private double x, y;

    @FXML
    void openTask(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://bit.ly/JavaExceptionsCJC"));
    }
    @FXML
    void closeTask(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage closeStage = new Stage();
        closeStage.setScene(new Scene(root));
        closeStage.initStyle(StageStyle.UNDECORATED);
        closeStage.show();
        new FadeIn(root).play();
    }
}
