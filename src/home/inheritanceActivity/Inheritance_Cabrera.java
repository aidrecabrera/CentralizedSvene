package home.inheritanceActivity;
import java.util.Scanner;
class A {
    int i, j;
    public void displayA() {
        System.out.println("\nContents of superOb: ");
        System.out.println("i and j: " + i + " " + j);
    }
}
class B extends A {
    int k;
    public void displayB() {
        System.out.println("\nContents of subOb: ");
        System.out.println("i and j: " + i + " " + j);
        System.out.println("k: " + k);
        System.out.println("\nSum of i, j, and k in subOb: ");
        System.out.println("i+j+k: " + (i + j + k));
    }
}
class Inheritance_Cabrera {
    public static void main(String[] args) {
        // Instantiating Objects
        A superOb = new A();
        B subOb = new B();

        // Instantiate Scanner
        Scanner superCScnr = new Scanner(System.in);
        Scanner subCScnr = new Scanner(System.in);

        // Superclass A value input
        System.out.println("Enter value of i in superOb:");
        superOb.i = superCScnr.nextInt();
        System.out.println("Enter value of j in superOb:");
        superOb.j = superCScnr.nextInt();

        // Subclass B value input
        System.out.println("Enter value of i in subOb:");
        subOb.i = subCScnr.nextInt();
        System.out.println("Enter value of j in subOb:");
        subOb.j = subCScnr.nextInt();
        System.out.println("Enter value of k in subOb:");
        subOb.k = subCScnr.nextInt();

        // Calls Attributes and Methods of Superclass A
        superOb.displayA();

        // Calls Attributes and Methods of Subclass B
        subOb.displayB();
    }
}