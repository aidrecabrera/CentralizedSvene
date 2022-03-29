package home.operatorsanddecisionp1;

import javax.swing.*;
public class dumb {
    void studentInput() {
        String scanUserCurrentName = JOptionPane.showInputDialog("Student Name: ");
        String scanCurrentSSCode = JOptionPane.showInputDialog("Session Code: ");
        String scanCurrentCRSCode = JOptionPane.showInputDialog("Course Code: ");
        int scanCurrentRegFee = Integer.parseInt(JOptionPane.showInputDialog("Registration Fee: "));
        String userCurrentName = scanUserCurrentName;
    }
}
