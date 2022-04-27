package home.CorBankAtmMachine;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class CompProgFinalTask_Cabrera {
    public static void main(String[] args) {
        CorBankIntroduction();
    }

    public static void CorBankIntroduction() {
        System.out.println("----------------------------------------");
        System.out.println("          Cor Jesu College, Inc");
        System.out.println("           ATM Machine Program");
        System.out.println("----------------------------------------");
        System.out.println("\nWelcome to Cor Bank ATM Machine!\n");
    }
}

class CorBankMenuInterface {
    Scanner mainScannerCorBank = new Scanner(System.in);
    DecimalFormat PhCurrencyFormat = new DecimalFormat("'Php '###,##0.00");
    HashMap<Integer, CorBankAccountLogic> CorBankHashMap = new HashMap<Integer, CorBankAccountLogic>();

    public void CorBankStudentLogin() throws IOException {
        boolean end = false;
        int CorBankAccountNumber = 0;
        int CorBankPinNumber = 0;
        while (!end) {
            try {
                System.out.println("Please enter your Cor Bank Account Number: ");
                CorBankAccountNumber = mainScannerCorBank.nextInt();
                System.out.println("Please enter your Cor Bank PIN Number: ");
                Iterator it = CorBankHashMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry) it.next();
                    CorBankAccountLogic acc = (CorBankAccountLogic) pair.getValue();
                    if (CorBankHashMap.containsKey(CorBankAccountNumber) && CorBankPinNumber == acc.getCorBankPinNumber()) {
                        CorBankAccountSelection(acc);
                        end = true;
                        break;
                    }
                }
                if (!end) {
                    System.out.println("Invalid Cor Bank Account Number or Pin Number");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Character(s). Input only numbers please.");
            }
        }
    }
}

class CorBankAccountLogic {
    // Cor Bank Account Variables
    private int CorBankAccountNumber;
    private int CorBankPinNumber;
    private double StudentCheckingBalance = 0;
    private double StudentSavingsBalance = 0;

    Scanner input = new Scanner(System.in);
    DecimalFormat PhCurrencyFormat = new DecimalFormat("'Php '###,##0.00");

    public CorBankAccountLogic() {

    }

    public CorBankAccountLogic(int CorBankAccountNumber, int CorBankPinNumber) {
        this.CorBankAccountNumber = CorBankAccountNumber;
        this.CorBankPinNumber = CorBankPinNumber;
    }

    public CorBankAccountLogic(int corBankAccountNumber, int corBankPinNumber, double studentCheckingBalance, double studentSavingsBalance) {
        CorBankAccountNumber = corBankAccountNumber;
        CorBankPinNumber = corBankPinNumber;
        StudentCheckingBalance = studentCheckingBalance;
        StudentSavingsBalance = studentSavingsBalance;
    }

    public int setCorBankAccountNumber(int corBankAccountNumber) {
        CorBankAccountNumber = corBankAccountNumber;
        return CorBankAccountNumber;
    }

    public int getCorBankAccountNumber() {
        return CorBankAccountNumber;
    }

    public int getCorBankPinNumber() {
        return CorBankPinNumber;
    }

    public int setCorBankPinNumber(int corBankPinNumber) {
        CorBankPinNumber = corBankPinNumber;
        return CorBankPinNumber;
    }

    public double getStudentCheckingBalance() {
        return StudentCheckingBalance;
    }

    public void setStudentCheckingBalance(double studentCheckingBalance) {
        StudentCheckingBalance = studentCheckingBalance;
    }

    public double getStudentSavingsBalance() {
        return StudentSavingsBalance;
    }

    public void setStudentSavingsBalance(double studentSavingsBalance) {
        StudentSavingsBalance = studentSavingsBalance;
    }

    public double calcCheckingWithdraw(double amount) {
        StudentCheckingBalance = (StudentCheckingBalance - amount);
        return StudentCheckingBalance;
    }

    public double calcSavingWithdraw(double amount) {
        StudentSavingsBalance = (StudentSavingsBalance - amount);
        return StudentSavingsBalance;
    }

    public double calcCheckingDeposit(double amount) {
        StudentCheckingBalance = (StudentCheckingBalance + amount);
        return StudentCheckingBalance;
    }

    public double calcSavingDeposit(double amount) {
        StudentCheckingBalance = (StudentCheckingBalance + amount);
        return StudentCheckingBalance;
    }

    public void calcCheckTransfer(double amount) {
        StudentCheckingBalance = (StudentCheckingBalance - amount);
        StudentSavingsBalance = (StudentSavingsBalance + amount);
    }

    public void calcSavingTransfer(double amount) {
        StudentSavingsBalance = (StudentSavingsBalance - amount);
        StudentCheckingBalance = (StudentCheckingBalance + amount);
    }

    public void getCheckingWithdrawInput() {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\nCurrent Student Checkings Account Balance: " + PhCurrencyFormat.format(StudentCheckingBalance));
                System.out.println("\nAmount you want to withdraw from Student Checkings Account");
                double amount = input.nextDouble();
                if ((StudentCheckingBalance - amount) >= 0 && amount >= 0) {
                    calcCheckingWithdraw(amount);
                    System.out.println("\nCurrent Student Checkings Account Balance: " + PhCurrencyFormat.format(StudentCheckingBalance));
                    end = true;
                } else {
                    System.out.println("\nBalance cannot be negative.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                input.next();
            }
        }
    }
}
