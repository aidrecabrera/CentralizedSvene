package home.looping;

import home.PyramidTaskController;

public class pyramidAlgorithm extends PyramidTaskController {
    int number = Integer.parseInt(pyramidSize.getText());
    public void firstPyramidCalc() {
        for(int i = 1; i <= number; ++i) {
            for(int j = 1; j <= number; ++j) {
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

    public void secondPyramidCalc() {
        for (int i = 1; i <= number; ++i) {
            for (int j = number-i; j >= 1; --j) {
                secondPyramid.appendText("");
            }
            for (int k = i; k >= 1; --k) {
                if (k>9) {
                    secondPyramid.appendText("  " + k);
                } else {
                    secondPyramid.appendText("    " + k);
                }
            }
            secondPyramid.appendText("\n");
        }
    }

    public void thirdPyramidCalc() {
        for (int i = 0; i <= number; ++i) {
            for (int j = number-i; j >= 1; --j) {
                if (j>9) {
                    thirdPyramid.appendText("  " + j);
                } else {
                    thirdPyramid.appendText("    " + j);
                }
            }
            thirdPyramid.appendText("\n");
        }
    }

    public void fourthPyramidCalc() {
        for (int i = number; i >= 0; --i) {
            for (int j = number; j >= i; --j) {
                fourthPyramid.appendText("");
            }
            for (int k = 1; k <= i; ++k) {
                if (k>10) {
                    fourthPyramid.appendText("   " + k);
                } else {
                    fourthPyramid.appendText("    " + k);
                }
            }
            fourthPyramid.appendText("\n");
        }
        fourthPyramid.appendText("\n\n\n");
    }
}
