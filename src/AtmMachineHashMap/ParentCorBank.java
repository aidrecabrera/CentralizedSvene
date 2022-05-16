package AtmMachineHashMap;
import animatefx.animation.FadeIn;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;

public class ParentCorBank extends Application {
    private double x, y;
    @Override
    public void start(Stage CorBankStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("AtmUI.fxml"));
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
    void LoginClick(ActionEvent actionEvent) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AccountTypeUI.fxml"));
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
        menuChoice = 1;
        mainMenu();
    }

    @FXML
    void RegisterClick(ActionEvent event) throws IOException {
        menuChoice = 2;
        mainMenu();
    }

    DecimalFormat moneyFormat = new DecimalFormat("'Php'###,##0.00");
    HashMap<Integer, Account> data = new HashMap<Integer, Account>();
    public int customerNumber = 0;
    public int pinNumber = 0;

    public void getLogin() throws IOException {
        boolean end = false;
        while (!end) {
            try {
                customerNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter your customer number: "));
                pinNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter your PIN number: "));
                Iterator it = data.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry) it.next();
                    Account acc = (Account) pair.getValue();
                    if (data.containsKey(customerNumber) && pinNumber == acc.getPinNumber()) {
                        getAccountType(acc);
                        end = true;
                        break;
                    }
                }
                if (!end) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Wrong Customer Number or Pin Number");
                }
            } catch (InputMismatchException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Invalid Character(s). Only Numbers.");
            }
        }
    }

    @FXML
    public void getAccountType(Account acc) {
        boolean end = false;
        String[] accessType = {"Checkings Account", "Savings Account", "Exit"};
        while (!end) {
            String accessTypeInput = String.valueOf(JOptionPane.showInputDialog(
                    null,
                    "Preferred session: ",
                    "Input", JOptionPane.QUESTION_MESSAGE,
                    null, accessType, accessType[0]));
            int selection = 0;
            if (accessTypeInput == "Checkings Account") {
                selection = 1;
            } else if (accessTypeInput == "Savings Account") {
                selection = 2;
            }

            switch (selection) {
                case 1:
                    getChecking(acc);
                    break;
                case 2:
                    getSaving(acc);
                    break;
                default:
                    System.exit(0);
            }
        }
    }

    public void getChecking(Account acc) {
        boolean end = false;
        String[] accountActions = {"View Balance", "Withdraw Funds", "Deposit Funds", "Transfer Funds", "Exit"};
        while (!end) {
            String accountActionsInput = String.valueOf(JOptionPane.showInputDialog(
                    null,
                    "Preferred session: ",
                    "Input", JOptionPane.QUESTION_MESSAGE,
                    null, accountActions, accountActions[0]));

            int selection = 0;
            if (accountActionsInput == "View Balance") {
                selection = 1;
            } else if (accountActionsInput == "Withdraw Funds") {
                selection = 2;
            } else if (accountActionsInput == "Deposit Funds") {
                selection = 3;
            } else if (accountActionsInput == "Transfer Funds") {
                selection = 4;
            } else if (accountActionsInput == "Exit") {
                selection = 5;
            }

            switch (selection) {
                case 1:
                    JOptionPane.showMessageDialog(
                            null,
                            "Checkings Account Balance: " + moneyFormat.format(acc.getCheckingBalance()));
                    break;
                case 2:
                    acc.getCheckingWithdrawInput();
                    break;
                case 3:
                    acc.getCheckingDepositInput();
                    break;

                case 4:
                    acc.getTransferInput("Checkings");
                    break;
                case 5:
                    end = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "Invalid Choice");
            }
        }
    }

    public void getSaving(Account acc) {
        boolean end = false;
        String[] accountActions = {"View Balance", "Withdraw Funds", "Deposit Funds", "Transfer Funds", "Exit"};
        while (!end) {
            String accountActionsInput = String.valueOf(JOptionPane.showInputDialog(
                    null,
                    "Preferred session: ",
                    "Input", JOptionPane.QUESTION_MESSAGE,
                    null, accountActions, accountActions[0]));

            int selection = 0;
            if (accountActionsInput == "View Balance") {
                selection = 1;
            } else if (accountActionsInput == "Withdraw Funds") {
                selection = 2;
            } else if (accountActionsInput == "Deposit Funds") {
                selection = 3;
            } else if (accountActionsInput == "Transfer Funds") {
                selection = 4;
            } else if (accountActionsInput == "Exit") {
                selection = 5;
            }

            switch (selection) {
                case 1:
                    JOptionPane.showMessageDialog(
                            null,
                            "Savings Account Balance: " + moneyFormat.format(acc.getSavingBalance()));
                    break;
                case 2:
                    acc.getsavingWithdrawInput();
                    break;
                case 3:
                    acc.getSavingDepositInput();
                    break;
                case 4:
                    acc.getTransferInput("Savings");
                    break;
                case 5:
                    end = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "Invalid Choice");
            }
        }
    }

    public int cst_no = 0;
    public int pin = 0;

    public void createAccount() throws IOException {
        boolean end = false;
        while (!end) {
            try {
                cst_no = Integer.parseInt(JOptionPane.showInputDialog(
                        null,
                        "Enter your customer number: "));
                Iterator it = data.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry) it.next();
                    if (!data.containsKey(cst_no)) {
                        end = true;
                    }
                }
                if (!end) {
                    JOptionPane.showMessageDialog(
                            null,
                            "This customer number is already registered");
                }
            } catch (InputMismatchException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Invalid input.");
            }
        }
        int pin = Integer.parseInt(JOptionPane.showInputDialog("Enter PIN to be registered: "));
        data.put(cst_no, new Account(cst_no, pin));
        JOptionPane.showMessageDialog(
                null,
                "Your new account has been successfully registered!");
        JOptionPane.showMessageDialog(
                null,
                "Redirecting to login.");
        getLogin();
    }

    public int menuChoice = 0;

    public void mainMenu() throws IOException {
        data.put(952141, new Account(952141, 191904, 1000, 5000));
        data.put(123, new Account(123, 123, 20000, 50000));
        String[] mainActions = {"Login", "Create Account"};
        boolean end = false;
        while (!end) {
            try {
//                String mainActionsUser = String.valueOf(JOptionPane.showInputDialog(
//                        null,
//                        "Preferred session: ",
//                        "Input", JOptionPane.QUESTION_MESSAGE,
//                        null, mainActions, mainActions[0]));
//
//                if (mainActionsUser == "Login") {
//                    menuChoice = 1;
//                } else if (mainActionsUser == "Create Account") {
//                    menuChoice = 2;
//                }

                switch (menuChoice) {
                    case 1:
                        getLogin();
                        end = true;
                        break;
                    case 2:
                        createAccount();
                        end = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(
                                null,
                                "Thank you for banking with Cor Bank!");
                        System.exit(0);
                }
            } catch (InputMismatchException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Thank you for banking with Cor Bank!");
                System.exit(0);
            }
        }
        JOptionPane.showMessageDialog(
                null,
                "Thank you for banking with Cor Bank!");
        System.exit(0);
    }
}

//class OptionMenu {
//    DecimalFormat moneyFormat = new DecimalFormat("'Php'###,##0.00");
//    HashMap<Integer, Account> data = new HashMap<Integer, Account>();
//    public int customerNumber = 0;
//    public int pinNumber = 0;
//
//    public void getLogin() throws IOException {
//        boolean end = false;
//        while (!end) {
//            try {
//                customerNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter your customer number: "));
//                pinNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter your PIN number: "));
//                Iterator it = data.entrySet().iterator();
//                while (it.hasNext()) {
//                    Map.Entry pair = (Map.Entry) it.next();
//                    Account acc = (Account) pair.getValue();
//                    if (data.containsKey(customerNumber) && pinNumber == acc.getPinNumber()) {
//                        getAccountType(acc);
//                        end = true;
//                        break;
//                    }
//                }
//                if (!end) {
//                    JOptionPane.showMessageDialog(
//                            null,
//                            "Wrong Customer Number or Pin Number");
//                }
//            } catch (InputMismatchException e) {
//                JOptionPane.showMessageDialog(
//                        null,
//                        "Invalid Character(s). Only Numbers.");
//            }
//        }
//    }
//
//    public void getAccountType(Account acc) {
//        boolean end = false;
//        String[] accessType = {"Checkings Account", "Savings Account", "Exit"};
//        while (!end) {
//            String accessTypeInput = String.valueOf(JOptionPane.showInputDialog(
//                    null,
//                    "Preferred session: ",
//                    "Input", JOptionPane.QUESTION_MESSAGE,
//                    null, accessType, accessType[0]));
//            int selection = 0;
//            if (accessTypeInput == "Checkings Account") {
//                selection = 1;
//            } else if (accessTypeInput == "Savings Account") {
//                selection = 2;
//            }
//
//            switch (selection) {
//                case 1:
//                    getChecking(acc);
//                    break;
//                case 2:
//                    getSaving(acc);
//                    break;
//                default:
//                    System.exit(0);
//            }
//        }
//    }
//
//    public void getChecking(Account acc) {
//        boolean end = false;
//        String[] accountActions = {"View Balance", "Withdraw Funds", "Deposit Funds", "Transfer Funds", "Exit"};
//        while (!end) {
//            String accountActionsInput = String.valueOf(JOptionPane.showInputDialog(
//                    null,
//                    "Preferred session: ",
//                    "Input", JOptionPane.QUESTION_MESSAGE,
//                    null, accountActions, accountActions[0]));
//
//            int selection = 0;
//            if (accountActionsInput == "View Balance") {
//                selection = 1;
//            } else if (accountActionsInput == "Withdraw Funds") {
//                selection = 2;
//            } else if (accountActionsInput == "Deposit Funds") {
//                selection = 3;
//            } else if (accountActionsInput == "Transfer Funds") {
//                selection = 4;
//            } else if (accountActionsInput == "Exit") {
//                selection = 5;
//            }
//
//            switch (selection) {
//                case 1:
//                    JOptionPane.showMessageDialog(
//                            null,
//                            "Checkings Account Balance: " + moneyFormat.format(acc.getCheckingBalance()));
//                    break;
//                case 2:
//                    acc.getCheckingWithdrawInput();
//                    break;
//                case 3:
//                    acc.getCheckingDepositInput();
//                    break;
//
//                case 4:
//                    acc.getTransferInput("Checkings");
//                    break;
//                case 5:
//                    end = true;
//                    break;
//                default:
//                    JOptionPane.showMessageDialog(
//                            null,
//                            "Invalid Choice");
//            }
//        }
//    }
//
//    public void getSaving(Account acc) {
//        boolean end = false;
//        String[] accountActions = {"View Balance", "Withdraw Funds", "Deposit Funds", "Transfer Funds", "Exit"};
//        while (!end) {
//            String accountActionsInput = String.valueOf(JOptionPane.showInputDialog(
//                    null,
//                    "Preferred session: ",
//                    "Input", JOptionPane.QUESTION_MESSAGE,
//                    null, accountActions, accountActions[0]));
//
//            int selection = 0;
//            if (accountActionsInput == "View Balance") {
//                selection = 1;
//            } else if (accountActionsInput == "Withdraw Funds") {
//                selection = 2;
//            } else if (accountActionsInput == "Deposit Funds") {
//                selection = 3;
//            } else if (accountActionsInput == "Transfer Funds") {
//                selection = 4;
//            } else if (accountActionsInput == "Exit") {
//                selection = 5;
//            }
//
//            switch (selection) {
//                case 1:
//                    JOptionPane.showMessageDialog(
//                            null,
//                            "Savings Account Balance: " + moneyFormat.format(acc.getSavingBalance()));
//                    break;
//                case 2:
//                    acc.getsavingWithdrawInput();
//                    break;
//                case 3:
//                    acc.getSavingDepositInput();
//                    break;
//                case 4:
//                    acc.getTransferInput("Savings");
//                    break;
//                case 5:
//                    end = true;
//                    break;
//                default:
//                    JOptionPane.showMessageDialog(
//                            null,
//                            "Invalid Choice");
//            }
//        }
//    }
//
//    public int cst_no = 0;
//    public int pin = 0;
//
//    public void createAccount() throws IOException {
//        boolean end = false;
//        while (!end) {
//            try {
//                cst_no = Integer.parseInt(JOptionPane.showInputDialog(
//                        null,
//                        "Enter your customer number: "));
//                Iterator it = data.entrySet().iterator();
//                while (it.hasNext()) {
//                    Map.Entry pair = (Map.Entry) it.next();
//                    if (!data.containsKey(cst_no)) {
//                        end = true;
//                    }
//                }
//                if (!end) {
//                    JOptionPane.showMessageDialog(
//                            null,
//                            "This customer number is already registered");
//                }
//            } catch (InputMismatchException e) {
//                JOptionPane.showMessageDialog(
//                        null,
//                        "Invalid input.");
//            }
//        }
//        int pin = Integer.parseInt(JOptionPane.showInputDialog("Enter PIN to be registered: "));
//        data.put(cst_no, new Account(cst_no, pin));
//        JOptionPane.showMessageDialog(
//                null,
//                "Your new account has been successfully registered!");
//        JOptionPane.showMessageDialog(
//                null,
//                "Redirecting to login.");
//        getLogin();
//    }
//
//    public int menuChoice = 0;
//
//    public void mainMenu() throws IOException {
//        data.put(952141, new Account(952141, 191904, 1000, 5000));
//        data.put(123, new Account(123, 123, 20000, 50000));
//        String[] mainActions = {"Login", "Create Account"};
//        boolean end = false;
//        while (!end) {
//            try {
////                String mainActionsUser = String.valueOf(JOptionPane.showInputDialog(
////                        null,
////                        "Preferred session: ",
////                        "Input", JOptionPane.QUESTION_MESSAGE,
////                        null, mainActions, mainActions[0]));
////
////                if (mainActionsUser == "Login") {
////                    menuChoice = 1;
////                } else if (mainActionsUser == "Create Account") {
////                    menuChoice = 2;
////                }
//
//                switch (menuChoice) {
//                    case 1:
//                        getLogin();
//                        end = true;
//                        break;
//                    case 2:
//                        createAccount();
//                        end = true;
//                        break;
//                    default:
//                        JOptionPane.showMessageDialog(
//                                null,
//                                "Thank you for banking with Cor Bank!");
//                        System.exit(0);
//                }
//            } catch (InputMismatchException e) {
//                JOptionPane.showMessageDialog(
//                        null,
//                        "Thank you for banking with Cor Bank!");
//                System.exit(0);
//            }
//        }
//        JOptionPane.showMessageDialog(
//                null,
//                "Thank you for banking with Cor Bank!");
//        System.exit(0);
//    }
//}

class Account {
    // variables
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    public Account() {
    }

    public Account(int customerNumber, int pinNumber) {
        this.customerNumber = customerNumber;
        this.pinNumber = pinNumber;
    }

    public Account(int customerNumber, int pinNumber, double checkingBalance, double savingBalance) {
        this.customerNumber = customerNumber;
        this.pinNumber = pinNumber;
        this.checkingBalance = checkingBalance;
        this.savingBalance = savingBalance;
    }

    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public double calcCheckingWithdraw(double amount) {
        checkingBalance = (checkingBalance - amount);
        return checkingBalance;
    }

    public double calcSavingWithdraw(double amount) {
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }

    public double calcCheckingDeposit(double amount) {
        checkingBalance = (checkingBalance + amount);
        return checkingBalance;
    }

    public double calcSavingDeposit(double amount) {
        savingBalance = (savingBalance + amount);
        return savingBalance;
    }

    public void calcCheckTransfer(double amount) {
        checkingBalance = checkingBalance - amount;
        savingBalance = savingBalance + amount;
    }

    public void calcSavingTransfer(double amount) {
        savingBalance = savingBalance - amount;
        checkingBalance = checkingBalance + amount;
    }

    public void getCheckingWithdrawInput() {
        boolean end = false;
        while (!end) {
            double amount;
            try {
                amount = Double.parseDouble(JOptionPane.showInputDialog(null,
                        "Current Checking Account Balance: " +
                                moneyFormat.format(checkingBalance) +
                                "\nAmount you want to withdraw from Checking Account:"));
                if ((checkingBalance - amount) >= 0 && amount >= 0) {
                    calcCheckingWithdraw(amount);
                    JOptionPane.showMessageDialog(null,
                            "Current Checking Account Balance: " + moneyFormat.format(checkingBalance));
                    end = true;
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Balance Cannot Be Negative.");
                }
            } catch (InputMismatchException e) {
                JOptionPane.showMessageDialog(null, "Invalid input");
            }
        }
    }

    public void getsavingWithdrawInput() {
        boolean end = false;
        while (!end) {
            try {
                double amount = Double.parseDouble(JOptionPane.showInputDialog(null,
                        "Current Savings Account Balance: " +
                                moneyFormat.format(savingBalance) +
                                "\nAmount you want to withdraw from Savings Account:"));
                if ((savingBalance - amount) >= 0 && amount >= 0) {
                    calcSavingWithdraw(amount);
                    JOptionPane.showMessageDialog(null,
                            "Current Savings Account Balance: " + moneyFormat.format(savingBalance));
                    end = true;
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Balance Cannot Be Negative.");
                }
            } catch (InputMismatchException e) {
                JOptionPane.showMessageDialog(null, "Invalid input");
            }
        }
    }

    public void getCheckingDepositInput() {
        boolean end = false;
        while (!end) {
            try {
                double amount = Double.parseDouble(JOptionPane.showInputDialog(
                        null,
                        "Current Checkings Account Balance: " +
                                moneyFormat.format(checkingBalance) +
                                "\nAmount you want to deposit to Checkings Account: "));
                if ((checkingBalance + amount) >= 0 && amount >= 0) {
                    calcCheckingDeposit(amount);
                    JOptionPane.showMessageDialog(
                            null,
                            "Current Checkings Account Balance: " + moneyFormat.format(checkingBalance));
                    end = true;
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Balance Cannot Be Negative.");
                }
            } catch (InputMismatchException e) {
                JOptionPane.showMessageDialog(null, "Invalid input");
                double amount = Double.parseDouble(JOptionPane.showInputDialog(
                        null,
                        "Current Checkings Account Balance: " +
                                moneyFormat.format(checkingBalance) +
                                "\nAmount you want to deposit to Checkings Account: "));
                if ((checkingBalance + amount) >= 0 && amount >= 0) {
                    calcCheckingDeposit(amount);
                    JOptionPane.showMessageDialog(
                            null,
                            "Current Checkings Account Balance: " + moneyFormat.format(checkingBalance));
                    end = true;
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Balance Cannot Be Negative.");
                }
            }
        }
    }

    public void getSavingDepositInput() {
        boolean end = false;
        while (!end) {
            try {
                double amount = Double.parseDouble(JOptionPane.showInputDialog(
                        null,
                        "Current Savings Account Balance: " +
                                moneyFormat.format(savingBalance) +
                                "\nAmount you want to deposit to Savings Account: "));
                if ((savingBalance + amount) >= 0 && amount >= 0) {
                    calcSavingDeposit(amount);
                    JOptionPane.showMessageDialog(
                            null,
                            "Current Savings Account Balance: " + moneyFormat.format(savingBalance));
                    end = true;
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Balance Cannot Be Negative.");
                }
            } catch (InputMismatchException e) {
                JOptionPane.showMessageDialog(null, "Invalid input");
                double amount = Double.parseDouble(JOptionPane.showInputDialog(
                        null,
                        "Current Savings Account Balance: " +
                                moneyFormat.format(savingBalance) +
                                "\nAmount you want to deposit to Savings Account: "));
                if ((savingBalance + amount) >= 0 && amount >= 0) {
                    calcSavingDeposit(amount);
                    JOptionPane.showMessageDialog(
                            null,
                            "Current Savings Account Balance: " + moneyFormat.format(savingBalance));
                    end = true;
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Balance Cannot Be Negative.");
                }
            }
        }
    }

    public void getTransferInput(String accType) {
        boolean end = false;
        String[] transferCheckingsOptions = {"Savings", "Cancel"};
        String[] transferSavingsOptions = {"Checkings", "Cancel"};
        while (!end) {
            try {
                if (accType.equals("Checkings")) {
                    String uCheckingsSelection = (String) JOptionPane.showInputDialog(
                            null,
                            "Select an account you wish to tranfers funds to: ",
                            "Account", JOptionPane.QUESTION_MESSAGE,
                            null, transferCheckingsOptions, transferCheckingsOptions[0]);

                    int choice = 0;
                    if (uCheckingsSelection == "Savings") {
                        choice = 1;
                    }
                    else if (uCheckingsSelection == "Cancel") {
                        choice = 2;
                    }
                    switch (choice) {
                        case 1:
                            double amount = Double.parseDouble(JOptionPane.showInputDialog(
                                    null,
                                    "Current Checkings Account Balance: " +
                                            moneyFormat.format(checkingBalance) +
                                            "\nCurrent Savings Account Balance: " +
                                            moneyFormat.format(savingBalance) +
                                            "\nAmount you want to deposit into your Savings Account: "));
                            if ((savingBalance + amount) >= 0 && (checkingBalance - amount) >= 0 && amount >= 0) {
                                calcCheckTransfer(amount);
                                JOptionPane.showMessageDialog(null,
                                        "Current Checkings Account Balance: " +
                                                moneyFormat.format(checkingBalance) +
                                                "\nCurrent Savings Account Balance: " +
                                                moneyFormat.format(savingBalance));
                                end = true;
                            } else {
                                JOptionPane.showMessageDialog(null,"Balance Cannot Be Negative.");
                            }
                            break;
                        case 2:
                            return;
                        default:
                            JOptionPane.showMessageDialog(null,"Invalid Choice.");
                            break;
                    }
                } else if (accType.equals("Savings")) {
                    String uSavingsSelection = (String) JOptionPane.showInputDialog(
                            null,
                            "Select an account you wish to tranfers funds to: ",
                            "Account", JOptionPane.QUESTION_MESSAGE,
                            null, transferSavingsOptions, transferSavingsOptions[0]);

                    int choice = 0;
                    if (uSavingsSelection == "Checkings") {
                        choice = 1;
                    }
                    else if (uSavingsSelection == "Cancel") {
                        choice = 2;
                    }
                    switch (choice) {
                        case 1:
                            double amount = Double.parseDouble(JOptionPane.showInputDialog(
                                    null,
                                    "Current Savings Account Balance: " +
                                            moneyFormat.format(savingBalance) +
                                            "\nCurrent Checkings Account Balance: " +
                                            moneyFormat.format(checkingBalance) +
                                            "\nAmount you want to deposit into your Checkings Account: "));
                            if ((checkingBalance + amount) >= 0 && (savingBalance - amount) >= 0 && amount >= 0) {
                                calcSavingTransfer(amount);
                                JOptionPane.showMessageDialog(null,
                                        "Current Savings Account Balance: " +
                                                moneyFormat.format(savingBalance) +
                                                "\nCurrent Checkings Account Balance: " +
                                                moneyFormat.format(checkingBalance));
                                end = true;
                            } else {
                                JOptionPane.showMessageDialog(null, "Balance Cannot Be Negative.");
                            }
                            break;
                        case 2:
                            return;
                        default:
                            JOptionPane.showMessageDialog(null, "Invalid Choice.");
                            break;
                    }
                }
            } catch (InputMismatchException e) {
                JOptionPane.showMessageDialog(null, "Invalid Choice.");
            }
        }
    }
}
