package home;

import animatefx.animation.FadeIn;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class InheritanceAndObjectsController {

    private double x, y;
    public Label spi;
    public Label spj;
    public Label sbi;
    public Label sbj;
    public Label sbk;
    public Label iSum;

    public class superClassA {
        int i;
        int j;
        void displayA() {
            spi.setText(String.valueOf(i));
            spj.setText(String.valueOf(j));
        }
    }
    public class subClassB extends superClassA {
        int k;
        void displayB() {
            sbi.setText(String.valueOf(i));
            sbj.setText(String.valueOf(j));
            sbk.setText(String.valueOf(k));
            iSum.setText(String.valueOf(i+j+k));
        }
    }

    @FXML
    void startInheritance(ActionEvent event) {
        superClassA superOb = new superClassA();
        subClassB subOb = new subClassB();
        int iSuperOb = Integer.parseInt(JOptionPane.showInputDialog("Enter value of i in superOb: "));
        int jSuperOb = Integer.parseInt(JOptionPane.showInputDialog("Enter value of j in superOb: "));
        int iSubOb = Integer.parseInt(JOptionPane.showInputDialog("Enter value of i in subOb: "));
        int jSubOb = Integer.parseInt(JOptionPane.showInputDialog("Enter value of j in subOb: "));
        int kSubOb = Integer.parseInt(JOptionPane.showInputDialog("Enter value of k in subOb: "));
        superOb.i = iSuperOb;
        superOb.j = jSuperOb;
        subOb.i = iSubOb;
        subOb.j = jSubOb;
        subOb.k = kSubOb;
        superOb.displayA();
        subOb.displayB();
    }

    @FXML
    void clearInheritance(ActionEvent event) {
        spi.setText("N/A");
        spj.setText("N/A");
        sbi.setText("N/A");
        sbj.setText("N/A");
        sbk.setText("N/A");
        iSum.setText("N/A");
    }

    @FXML
    void openTask(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://bit.ly/CJCJavaInheritance"));
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
