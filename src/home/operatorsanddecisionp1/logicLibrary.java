package home.operatorsanddecisionp1;
import javax.swing.*;
public class logicLibrary {
    public immutableLibrary referDataLibrary = new immutableLibrary();
    public String userSSCodeInput;
    public String userCRSCodeInput;
    public double userRegFeeInput;
    double discountAmount;
    double finalUserPercentDiscount;
    public double finalTotalBalance;
    String finalUserSession;
    public String userCurrentName;
    public String currentSS;
    public String currentSSCode;
    public String currentCRSCode;
    public double currentRegFee;

    public void studentInputNewVersion(){
        String scanUserCurrentFName = JOptionPane.showInputDialog("First Name: ");

        String scanCurrentSS = String.valueOf(JOptionPane.showInputDialog(
                null,
                "Preferred session: ",
                "Input", JOptionPane.QUESTION_MESSAGE,
                null, referDataLibrary.ssDataList, referDataLibrary.ssDataList[0]));

        JOptionPane.showMessageDialog(
                null,
                "Student Name: " + userCurrentName + '\n' + "Session: " + currentSS +
                        '\n' + "Course Description: " + referDataLibrary.courseName + '\n' + "Total Balance: Php " + finalTotalBalance);

//        String scanUserCurrentFName = JOptionPane.showInputDialog("First Name: ");
//        String scanUserCurrentMName = JOptionPane.showInputDialog("Middle Name: ");
//        String scanUserCurrentLName = JOptionPane.showInputDialog("Last Name: ");
//        String scanCurrentSS = String.valueOf(JOptionPane.showInputDialog(
//                null,
//                "Preferred session: ",
//                "Input", JOptionPane.QUESTION_MESSAGE,
//                null, referDataLibrary.ssDataList, referDataLibrary.ssDataList[0]));
//        String scanCurrentCRSCode = (String) JOptionPane.showInputDialog(
//                null,
//                "Programming Course: ",
//                "Input", JOptionPane.QUESTION_MESSAGE,
//                null, referDataLibrary.crsDescriptionDataList, referDataLibrary.crsDescriptionDataList[0]);
//        double scanCurrentRegFee = Integer.parseInt(JOptionPane.showInputDialog("Registration Fee: "));
//
//        char converToMiddleInitial = scanUserCurrentMName.charAt(0);
//        userCurrentName = scanUserCurrentFName + " " + converToMiddleInitial + "." + " " + scanUserCurrentLName;
//        currentSS = scanCurrentSS;
//        currentCRSCode = scanCurrentCRSCode;
//        currentRegFee = scanCurrentRegFee;
    }
    public void cjcLogic() {
        switch (userSSCodeInput) {
            case "Morning":
                finalUserSession = referDataLibrary.ssDataList[0];
                break;
            case "Afternoon":
                finalUserSession = referDataLibrary.ssDataList[1];
                break;
        }
        switch (userCRSCodeInput) {
            case "C++":
                referDataLibrary.cPlusPlus();
                break;
            case "Java":
                referDataLibrary.java();
                break;
            case "Visual Basic":
                referDataLibrary.visualBasic();
                break;
        }
        if (currentRegFee <= 4499) {
            finalUserPercentDiscount = 0;
        }
        else if ((currentRegFee >= 4500) || (currentRegFee <= 5499)) {
            finalUserPercentDiscount = 2;
        }
        else if ((currentRegFee >= 5500) || (currentRegFee <= 6499)) {
            finalUserPercentDiscount = 4;
        }
        else if (currentRegFee >= 6500) {
            finalUserPercentDiscount = 6;
        }
    }

    public void cjcComputation() {
        if (currentRegFee > referDataLibrary.courseFee) {
            currentRegFee = referDataLibrary.courseFee;
            finalUserPercentDiscount = 0;
        }
        discountAmount = referDataLibrary.courseFee * (finalUserPercentDiscount/100);
        finalTotalBalance = referDataLibrary.courseFee - (currentRegFee + discountAmount);
    }
    public void cjcOutput() {
        JOptionPane.showMessageDialog(null, "Student Name: " + userCurrentName + '\n' + "Session: " + currentSS + '\n' + "Course Description: " + referDataLibrary.courseName + '\n' + "Total Balance: Php " + finalTotalBalance);
    }
}
