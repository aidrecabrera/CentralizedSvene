package home;

import animatefx.animation.FadeIn;
import home.operatorsanddecisionp1.logicLibrary;
import home.operatorsanddecisionp1.studentMethods;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class DecisionsStructuresController implements Initializable{

    @FXML
    private TableView<studentMethods> enrolledStudentTable;

    @FXML
    private TableColumn<studentMethods, String> studentName;

    @FXML
    private TableColumn<studentMethods, String> studentSession;

    @FXML
    private TableColumn<studentMethods, String> studentCourse;

    @FXML
    private TableColumn<studentMethods, String> totalBalance;

    ObservableList<studentMethods> listOfStudents = FXCollections.observableArrayList(
            new studentMethods("Aidre Love S. Cabrera", "Afternoon", "Java", 7721.37),
            new studentMethods("Trisha Angela L. Talagtag", "Afternoon", "Java", 7143.42),
            new studentMethods("Svene C. Sismar", "Morning", "Visual Basic", 7370.07),
            new studentMethods("Apple Joy P. Flores", "Morning", "Visual Basic", 3317.05),
            new studentMethods("Jezreel Albino", "Morning", "C++", 5305.03)
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        studentCourse.setCellValueFactory(new PropertyValueFactory<>("studentCourse"));
        studentSession.setCellValueFactory(new PropertyValueFactory<>("studentSession"));
        totalBalance.setCellValueFactory(new PropertyValueFactory<>("totalBalance"));
        enrolledStudentTable.setItems(listOfStudents);
    }


    @FXML
    private Label totBal;

    @FXML
    private Label courseDesc;

    @FXML
    private Label sessIon;

    @FXML
    private Label fullName;

    @FXML
    void calculateDec(ActionEvent event) {
        logicLibrary userInputProcess = new logicLibrary();

        userInputProcess.studentInputNewVersion();
        userInputProcess.userSSCodeInput = userInputProcess.currentSS;
        userInputProcess.userCRSCodeInput = userInputProcess.currentCRSCode;
        userInputProcess.userRegFeeInput = userInputProcess.currentRegFee;

        userInputProcess.cjcLogic();
        userInputProcess.cjcComputation();
        userInputProcess.cjcOutput();

        fullName.setText(userInputProcess.userCurrentName);
        sessIon.setText(userInputProcess.currentSS);
        courseDesc.setText(userInputProcess.referDataLibrary.courseName);
        totBal.setText(String.valueOf(userInputProcess.finalTotalBalance));

        studentMethods newStudent = new studentMethods(userInputProcess.userCurrentName, userInputProcess.currentSS, userInputProcess.referDataLibrary.courseName, userInputProcess.finalTotalBalance);
        enrolledStudentTable.getItems().add(newStudent);
    }

    private double x, y;
    @FXML
    void closeTask(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Home.fxml")));
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
