package home.array;

public class ConsoleArray {

    // This is to allow the user to access the progam
    public static void main(String[] args) {

      	/* Interface is the name of the object to access the
        Executable Method from the InterfaceExecutable.java */
        InterfaceExecutable Interface = new InterfaceExecutable();

        // This is the introductory line prior the execution
        System.out.println("----------------------------------------");
        System.out.println("          Cor Jesu College, Inc");
        System.out.println("          Week 11 - Java Arrays");
        System.out.println("        Authored by Aidre Cabrera");
        System.out.println("----------------------------------------");
        System.out.println("\nWelcome to Galors Inn Booking Program!\n");

        // This call the ExecutableMethod from the created object
        Interface.ExecutableMethod(); // <--- Therefore, the program starts here :)
    }
}