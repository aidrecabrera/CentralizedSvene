package home;

import home.operatorsanddecisionp1.*;
import animatefx.animation.FadeIn;
import home.operatorsanddecisionp1.logicLibrary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.text.html.ImageView;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private double x, y;

    @FXML
    private Button homeButton1;
    @FXML
    private Button homeButton2;
    @FXML
    private Button homeButton3;
    @FXML
    private Button homeButton4;
    @FXML
    private Button homeButton5;
    @FXML
    private Button homeButton6;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    private void closeWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        ((Node) event.getSource()).getScene().getWindow().hide();
        Stage mainStage = new Stage();
        mainStage.setScene(new Scene(root));
        //set stage borderless
        mainStage.initStyle(StageStyle.UNDECORATED);
        mainStage.close();
        new FadeIn(root).play();
    }

    //Social Media Links
    @FXML
    public void facebookLink(MouseEvent mouseEvent) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.facebook.com/aidrecabrera777"));
    }
    @FXML
    public void messengerLink(MouseEvent mouseEvent) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.messenger.com//t/100054480407046"));
    }
    @FXML
    public void twitterLink(MouseEvent mouseEvent) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.twitter.com/aidrecabrera"));
    }
    @FXML
    public void githubLink(MouseEvent mouseEvent) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.github.com/aidrecabrera"));
    }

    public void modifyName(MouseEvent mouseEvent) throws URISyntaxException, IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("modifyEnterName.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage pyramidStage = new Stage();
            //set stage borderless
            pyramidStage.initStyle(StageStyle.UNDECORATED);
            pyramidStage.setScene(new Scene(root1));
            pyramidStage.show();

            new FadeIn(root1).play();

            //drag it here
            root1.setOnMousePressed(event -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });
            root1.setOnMouseDragged(event -> {
                pyramidStage.setX(event.getScreenX() - x);
                pyramidStage.setY(event.getScreenY() - y);
            });

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    //PanelButtons
    //Pyramid Button
    public void pyramidClick(javafx.event.ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PyramidTask.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            ((Node) actionEvent.getSource()).getScene().getWindow().hide();
            Stage pyramidStage = new Stage();
            //set stage borderless
            pyramidStage.initStyle(StageStyle.UNDECORATED);
            pyramidStage.setScene(new Scene(root1));
            pyramidStage.show();

            new FadeIn(root1).play();

            //drag it here
            root1.setOnMousePressed(event -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });
            root1.setOnMouseDragged(event -> {
                pyramidStage.setX(event.getScreenX() - x);
                pyramidStage.setY(event.getScreenY() - y);
            });

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void firstJavaClick(javafx.event.ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FirstJava.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            ((Node) actionEvent.getSource()).getScene().getWindow().hide();
            Stage pyramidStage = new Stage();
            //set stage borderless
            pyramidStage.initStyle(StageStyle.UNDECORATED);
            pyramidStage.setScene(new Scene(root1));
            pyramidStage.show();

            new FadeIn(root1).play();

            //drag it here
            root1.setOnMousePressed(event -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });
            root1.setOnMouseDragged(event -> {
                pyramidStage.setX(event.getScreenX() - x);
                pyramidStage.setY(event.getScreenY() - y);
            });

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void VariablesKeyClicked(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VariablesKey.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            ((Node) actionEvent.getSource()).getScene().getWindow().hide();
            Stage pyramidStage = new Stage();
            //set stage borderless
            pyramidStage.initStyle(StageStyle.UNDECORATED);
            pyramidStage.setScene(new Scene(root1));
            pyramidStage.show();

            new FadeIn(root1).play();

            //drag it here
            root1.setOnMousePressed(event -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });
            root1.setOnMouseDragged(event -> {
                pyramidStage.setX(event.getScreenX() - x);
                pyramidStage.setY(event.getScreenY() - y);
            });

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void operateClick(javafx.event.ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OperatorsStructures.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            ((Node) actionEvent.getSource()).getScene().getWindow().hide();
            Stage pyramidStage = new Stage();
            //set stage borderless
            pyramidStage.initStyle(StageStyle.UNDECORATED);
            pyramidStage.setScene(new Scene(root1));
            pyramidStage.show();

            new FadeIn(root1).play();

            //drag it here
            root1.setOnMousePressed(event -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });
            root1.setOnMouseDragged(event -> {
                pyramidStage.setX(event.getScreenX() - x);
                pyramidStage.setY(event.getScreenY() - y);
            });

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void decstrucClick(javafx.event.ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DecisionsStructures.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            ((Node) actionEvent.getSource()).getScene().getWindow().hide();
            Stage pyramidStage = new Stage();
            //set stage borderless
            pyramidStage.initStyle(StageStyle.UNDECORATED);
            pyramidStage.setScene(new Scene(root1));
            pyramidStage.show();

            new FadeIn(root1).play();

            //drag it here
            root1.setOnMousePressed(event -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });
            root1.setOnMouseDragged(event -> {
                pyramidStage.setX(event.getScreenX() - x);
                pyramidStage.setY(event.getScreenY() - y);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loopClick(javafx.event.ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Looping.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            ((Node) actionEvent.getSource()).getScene().getWindow().hide();
            Stage pyramidStage = new Stage();
            //set stage borderless
            pyramidStage.initStyle(StageStyle.UNDECORATED);
            pyramidStage.setScene(new Scene(root1));
            pyramidStage.show();

            new FadeIn(root1).play();

            //drag it here
            root1.setOnMousePressed(event -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });
            root1.setOnMouseDragged(event -> {
                pyramidStage.setX(event.getScreenX() - x);
                pyramidStage.setY(event.getScreenY() - y);
            });

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void exceptClick(javafx.event.ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Exceptions.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            ((Node) actionEvent.getSource()).getScene().getWindow().hide();
            Stage pyramidStage = new Stage();
            //set stage borderless
            pyramidStage.initStyle(StageStyle.UNDECORATED);
            pyramidStage.setScene(new Scene(root1));
            pyramidStage.show();

            new FadeIn(root1).play();

            //drag it here
            root1.setOnMousePressed(event -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });
            root1.setOnMouseDragged(event -> {
                pyramidStage.setX(event.getScreenX() - x);
                pyramidStage.setY(event.getScreenY() - y);
            });

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
