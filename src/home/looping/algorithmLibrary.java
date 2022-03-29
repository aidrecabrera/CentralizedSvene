package home.looping;

public class algorithmLibrary {
    int number;
    void leftTriangle() {
        for(int i = 1; i <= this.number; ++i) {
            for(int j = 1; j <= this.number; ++j) {
                if (j <= i) {
                    if (j<10) {
                        System.out.print(" " + j + " ");
                    } else {
                        System.out.print(j + " ");
                    }
                }
            }
            System.out.println();
        }
    }
    void rightTriangle() {
        for (int i = 1; i <= this.number; ++i) {
            for (int j = this.number-i; j >= 1; --j) {
                System.out.print("   ");
            }
            for (int k = i; k >= 1; --k) {
                if (k>9) {
                    System.out.print(" " + k);
                } else {
                    System.out.print("  " + k);
                }
            }
            System.out.println();
        }
    }
    void invertedLeftTriangle() {
        for (int i = 0; i <= this.number; ++i) {
            for (int j = this.number-i; j >= 1; --j) {
                if (j>9) {
                    System.out.print(j + " ");
                } else {
                    System.out.print(" " + j + " ");
                }
            }
            System.out.println();
        }
    }
    void invertedRightTriangle() {
        for (int i = this.number; i >= 0; --i) {
            for (int j = this.number; j >= i; --j) {
                System.out.print("   ");
            }
            for (int k = 1; k <= i; ++k) {
                if (k>10) {
                    System.out.print(" " + k);
                } else {
                    System.out.print("  " + k);
                }
            }
            System.out.println();
        }
    }
}

