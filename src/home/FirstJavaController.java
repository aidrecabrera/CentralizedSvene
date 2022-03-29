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

public class FirstJavaController {

    double x, y;

    @FXML
    void visitTask1(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://classroom.google.com/u/1/c/NDUxODkwNzkxMTEx/a/NDY0OTc5OTgzOTgx/details"));
    }

    @FXML
    void closeTask(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        Stage closeStage = new Stage();
        closeStage.setScene(new Scene(root));
        //set stage borderless
        closeStage.initStyle(StageStyle.UNDECORATED);
        //drag it here
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            closeStage.setX(event.getScreenX() - x);
            closeStage.setY(event.getScreenY() - y);
        });
        closeStage.show();
        new FadeIn(root).play();
    }

}
