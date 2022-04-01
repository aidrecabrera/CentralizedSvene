package softfiles;

public class week9 {

    static void sectionB() {
        try {
            int[] myNumbers = {1, 2, 3};
            System.out.println(myNumbers[10]);
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        } finally {
            System.out.println("The 'try 'catch' is finished");
        }
    }

    static void sectionC1() {
        int n = 5;
        try {
            n = n / 0;
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception Caught");
        } catch (NumberFormatException e) {
                System.out.println("Number Format Exception Caught");
        } finally {
                System.out.println("Done");
        }
        }

    static void sectionC2() {
        int n = 5;
        try {
            n = n / 0;
        }
        catch (Exception e) {
            System.out.println("Exception Caught");
        }
        finally {
            System.out.println("Done");
        }
    }

    public static void main(String[] args) {
        System.out.println("Section B\n");
        sectionB();
        System.out.println("\nSection C, #1\n");
        sectionC1();
        System.out.println("\nSection C, #2\n");
        sectionC2();
    }
}
