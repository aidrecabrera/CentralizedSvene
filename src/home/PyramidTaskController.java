package home;

import home.looping.pyramidAlgorithm;

import animatefx.animation.FadeIn;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class PyramidTaskController extends Application {

    private double x, y;

    @Override
    public void start(Stage secondaryStage) {
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void closeTask(javafx.event.ActionEvent actionEvent) throws IOException {
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

    @FXML
    public TextField pyramidSize;

    @FXML
    public TextArea firstPyramid;

    @FXML
    public TextArea secondPyramid;

    @FXML
    public TextArea fourthPyramid;

    @FXML
    public TextArea thirdPyramid;

    int pySize;

    private void firstPyramidCalc() {
        for(int i = 1; i <= pySize; ++i) {
            for(int j = 1; j <= pySize; ++j) {
                if (j <= i) {
                    if (j<10) {
                        firstPyramid.appendText("  " + j + "  ");
                    } else {
                        firstPyramid.appendText(j + "   ");
                    }
                }
            }
            firstPyramid.appendText("\n");
        }
    }

    private void secondPyramidCalc() {
        for (int i = 1; i <= pySize; ++i) {
            for (int j = pySize-i; j >= 1; --j) {
                secondPyramid.appendText("      ");
            }
            for (int k = i; k >= 1; --k) {
                if (k>=10) {
                    secondPyramid.appendText("  " + k);
                } else {
                    secondPyramid.appendText("    " + k);
                }
            }
            secondPyramid.appendText("\n");
        }
    }

    private void thirdPyramidCalc() {
        for (int i = 0; i <= pySize; ++i) {
            for (int j = pySize-i; j >= 1; --j) {
                if (j>9) {
                    thirdPyramid.appendText("  " + j);
                } else {
                    thirdPyramid.appendText("    " + j);
                }
            }
            thirdPyramid.appendText("\n");
        }
    }

    private void fourthPyramidCalc() {
        for (int i = pySize; i >= 0; --i) {
            for (int j = pySize; j >= i; --j) {
                fourthPyramid.appendText("      ");
            }
            for (int k = 1; k <= i; ++k) {
                if (k>10) {
                    fourthPyramid.appendText("  " + k);
                } else {
                    fourthPyramid.appendText("    " + k);
                }
            }
            fourthPyramid.appendText("\n");
        }
        fourthPyramid.appendText("\n\n\n");
    }

    @FXML
    void calculatePyramid(ActionEvent event) {
        pySize = Integer.parseInt(pyramidSize.getText());
        firstPyramidCalc();
        secondPyramidCalc();
        thirdPyramidCalc();
        fourthPyramidCalc();
    }

    @FXML
    void clearPyramid(ActionEvent event) {
        firstPyramid.clear();
        secondPyramid.clear();
        thirdPyramid.clear();
        fourthPyramid.clear();
    }
}
