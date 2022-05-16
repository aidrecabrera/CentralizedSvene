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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
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
    private PasswordField thisInputPin;

    @FXML
    public Text thisCheckingBalance;

    @FXML
    public Text thisSavingsBalance;

    public static ArrayList<String> arrUsername = new ArrayList<>();
    public static ArrayList<Integer> arrUserpin = new ArrayList<>();
    public static ArrayList<Double> arrCheckingBalance = new ArrayList<>();
    public static ArrayList<Double> arrSavingsBalance = new ArrayList<>();
    public static int indexReference = 0;

    @FXML
    void loginClick(ActionEvent actionEvent) {
        String inputUsername = thisInputNumber.getText();
        int inputUserpin = Integer.parseInt(thisInputPin.getText());
        indexReference = arrUsername.indexOf(inputUsername);
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
    }


    public static double CheckingSessionBalance = 0.0;
    public static double SavingsSessionBalance = 0.0;
    public static double NewCheckingsBalance = 0.0;
    public static double NewSavingsBalance = 0.0;
    public static String[] typesOfAcc = {"Savings", "Checkings"};

    @FXML
    void withdrawClick(ActionEvent event) {
        boolean end = false;
        while (!end) {
            String withdrawAccType = String.valueOf(JOptionPane.showInputDialog(
                    null,
                    "Select Account to Withdraw: ",
                    "Withdraw Funds", JOptionPane.QUESTION_MESSAGE,
                    null, typesOfAcc, typesOfAcc[0]));
            double amount = Double.parseDouble(JOptionPane.showInputDialog(null, "Input amount to withdraw: "));
            if (withdrawAccType == "Savings") {
                try {
                    if (amount > arrSavingsBalance.get(indexReference)) {
                        JOptionPane.showMessageDialog(null, "Amount Greater than Balance!");
                    } else {
                        NewSavingsBalance = SavingsSessionBalance - amount;
                        arrSavingsBalance.set(indexReference, NewSavingsBalance);
                        BalanceProcessing();
                        end = true;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Input invalid!");
                }
            } else if (withdrawAccType == "Checkings") {
                try {
                    if (amount > arrSavingsBalance.get(indexReference)) {
                        JOptionPane.showMessageDialog(null, "Amount Greater than Balance!");
                    } else {
                        NewCheckingsBalance = CheckingSessionBalance - amount;
                        arrCheckingBalance.set(indexReference, NewCheckingsBalance);
                        BalanceProcessing();
                        end = true;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Input invalid!");
                }
            }
        }
    }

    @FXML
    void DespositClick(ActionEvent event) {
        boolean end = false;
        while (!end) {
            String withdrawAccType = String.valueOf(JOptionPane.showInputDialog(
                    null,
                    "Select Account to Deposit: ",
                    "Withdraw", JOptionPane.QUESTION_MESSAGE,
                    null, typesOfAcc, typesOfAcc[0]));
            double amount = Double.parseDouble(JOptionPane.showInputDialog(null, "Input amount to withdraw: "));
            if (withdrawAccType == "Savings") {
                try {
                    NewSavingsBalance = SavingsSessionBalance + amount;
                    arrSavingsBalance.set(indexReference, NewSavingsBalance);
                    BalanceProcessing();
                    end = true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Input invalid!");
                }
            } else if (withdrawAccType == "Checkings") {
                try {
                    NewCheckingsBalance = CheckingSessionBalance + amount;
                    arrCheckingBalance.set(indexReference, NewCheckingsBalance);
                    BalanceProcessing();
                    end = true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Input invalid!");
                }
            }
        }
    }

    @FXML
    void TransferClick(ActionEvent event) {
        boolean end = false;
        while (!end) {
            String fromTransferType = String.valueOf(JOptionPane.showInputDialog(
                    null,
                    "Transfer Funds from: ",
                    "Transfer Funds", JOptionPane.QUESTION_MESSAGE,
                    null, typesOfAcc, typesOfAcc[0]));
            double amount = Double.parseDouble(JOptionPane.showInputDialog(null, "Input amount to transfer: "));
            if (fromTransferType == "Savings") {
                try {
                    if (amount > arrSavingsBalance.get(indexReference)) {
                        JOptionPane.showMessageDialog(null, "Amount Greater than Saving Balance!");
                    } else {
                        NewSavingsBalance = (SavingsSessionBalance - amount);
                        NewCheckingsBalance = (CheckingSessionBalance + amount);
                        arrCheckingBalance.set(indexReference, NewCheckingsBalance);
                        arrSavingsBalance.set(indexReference, NewSavingsBalance);
                        BalanceProcessing();
                        end = true;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Input invalid!");
                }
            } else if (fromTransferType == "Checkings") {
                try {
                    if (amount > arrCheckingBalance.get(indexReference)) {
                        JOptionPane.showMessageDialog(null, "Amount Greater than Checking Balance!");
                    } else {
                        NewCheckingsBalance = (CheckingSessionBalance - amount);
                        NewSavingsBalance = (SavingsSessionBalance + amount);
                        arrCheckingBalance.set(indexReference, NewCheckingsBalance);
                        arrSavingsBalance.set(indexReference, NewSavingsBalance);
                        BalanceProcessing();
                        end = true;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Input invalid!");
                }
            }
        }
    }

    void BalanceProcessing() {
        CheckingSessionBalance = arrCheckingBalance.get(indexReference);
        SavingsSessionBalance = arrSavingsBalance.get(indexReference);
        if (CheckingSessionBalance == 0) {
            thisCheckingBalance.setText("No Balance");
        } else {
            thisCheckingBalance.setText(String.valueOf(CheckingSessionBalance));
        }
        if (SavingsSessionBalance == 0) {
            thisSavingsBalance.setText("No Balance");
        } else {
            thisSavingsBalance.setText(String.valueOf(SavingsSessionBalance));
        }
    }

    @FXML
    void ShowBalanceClick(ActionEvent event) {
        BalanceProcessing();
    }
}
