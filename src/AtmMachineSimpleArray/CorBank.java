package AtmMachineSimpleArray;

import animatefx.animation.FadeIn;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.util.ArrayList;

public class CorBank extends Application {
    private double x, y;
    @Override
    public void start(Stage CorBankStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("CorBank.fxml"));
        CorBankStage.setScene(new Scene(root));
        //set stage borderless
        CorBankStage.initStyle(StageStyle.UNDECORATED);
        CorBankStage.initStyle(StageStyle.TRANSPARENT);
        //drag it here
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            CorBankStage.setX(event.getScreenX() - x);
            CorBankStage.setY(event.getScreenY() - y);
        });
        CorBankStage.show();
        new FadeIn(root).play();
    }
    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    private TextField thisInputNumber;

    @FXML
    private TextField thisInputPin;

    ArrayList<String> arrUsername = new ArrayList<>();
    ArrayList<Integer> arrUserpin = new ArrayList<>();
    ArrayList<Double> arrCheckingBalance = new ArrayList<>();
    ArrayList<Double> arrSavingsBalance = new ArrayList<>();

    @FXML
    void loginClick(ActionEvent actionEvent) {
        String inputUsername = thisInputNumber.getText();
        int inputUserpin = Integer.parseInt(thisInputPin.getText());
        if (arrUsername.contains(inputUsername) && arrUserpin.contains(inputUserpin)) {
            JOptionPane.showMessageDialog(null, "Successfully Logged in. Welcome to Cor Bank!");
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CorBankSavings.fxml"));
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
        } else {
            JOptionPane.showMessageDialog(null, "Account Authentication Error. User does not exist or wrong information");
        }
    }

    @FXML
    private Label thisCheckingBalance;

    @FXML
    private Label thisSavingsBalance;

    @FXML
    void registerClick(ActionEvent event) {
        String inputUsername = thisInputNumber.getText();
        int inputUserpin = Integer.parseInt(thisInputPin.getText());
        if (!(arrUsername.contains(inputUsername)) && !(arrUsername.contains(inputUserpin))) {
            arrUsername.add(inputUsername);
            arrUserpin.add(inputUserpin);
            arrCheckingBalance.add(0.0);
            arrSavingsBalance.add(0.0);
            JOptionPane.showMessageDialog(null, "Account Registered. Welcome to Cor Bank!");
        } else {
            JOptionPane.showMessageDialog(null, "Account already registered");
        }
        System.out.println(arrUsername);
        System.out.println(arrUserpin);
        System.out.println(arrCheckingBalance);
        System.out.println(arrSavingsBalance);
        System.out.println(arrUsername.indexOf(inputUsername));
        System.out.println(arrUserpin.indexOf(inputUserpin));
    }

    @FXML
    void withdrawClick(ActionEvent event) {

    }

    @FXML
    void DespositClick(ActionEvent event) {

    }

    @FXML
    void TransferClick(ActionEvent event) {

    }

}
