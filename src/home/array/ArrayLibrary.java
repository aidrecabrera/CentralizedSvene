package home.array;

import java.util.Scanner;

    // Don't worry, this will be abstracted
public class ArrayLibrary {
    Scanner mainScanner = new Scanner(System.in);
    // Array Library for Accommodation
    String[] AvailableAccommodations = {
            "Office Room",
            "Family Room",
            "Sports Room",
    };
    // Array Library for Room Rates
    double[] CurrentRoomRates = {
            900.00,
            750.00,
            650.00,
            825.00
    };
    // Array Library for Service Rates of Rooms
    int[] CurrentServiceRate = {
            6,
            4,
            2
    };

    String userName;
    int userRoomRate;
    int userAccommodation;
    double SessionServiceRate;
    String SessionAccomodation;
    double SessionRoomRate;
    int SessionDaysStay;
    double AccommodationFee, ServiceFee, GrossFee;

    // Container for calculated values
    double[] BillContainer = new double[3];

    // Container for the receipt contents
    String[] FinalOutputContainer = new String[9];

    // This is to acquire the name of the guest
    void Name() {
        System.out.println("Guest Name: ");
        userName = mainScanner.nextLine();
        while ((userName.length() > 20)) {
            System.out.println("Invalid input! Try again.");
            userName = mainScanner.nextLine();
        }
        System.out.println("\nHi, " + userName + "\n");
        System.out.println("Please enter the necessary details :)\n");
    }

    // The methods are intuitive enough since it is labeled properly.
    // Format is [DETAIL TYPE] + Logic()
    void AccomodationLogic() {
        System.out.println("Accomodation Code (1-3): ");
        userAccommodation = mainScanner.nextInt();
        SessionAccomodation = AvailableAccommodations[userAccommodation-1];
        SessionServiceRate = CurrentServiceRate[userAccommodation-1];
    }
    void RoomRateLogic() {
        System.out.println("Room Number (1-4): ");
        userRoomRate = mainScanner.nextInt();
        while (userRoomRate > 4) {
            System.out.println("We only have 4 Rooms. Please re-input!");
            userRoomRate = mainScanner.nextInt();
        }
        SessionRoomRate = CurrentRoomRates[userRoomRate-1];
    }
    void DaysStay() {
        System.out.println("Days Stay (2-30): ");
        SessionDaysStay = mainScanner.nextInt();
        while ((SessionDaysStay < 2) || (SessionDaysStay > 30)) {
            System.out.println("We only allow the amount of days stay from 2 to 30 days. Please re-input!");
            SessionDaysStay = mainScanner.nextInt();
        }
    }
    void OverallCalculation() {
        AccommodationFee = SessionRoomRate * SessionDaysStay;
        ServiceFee = AccommodationFee * (SessionServiceRate/100);
        GrossFee = AccommodationFee + ServiceFee;
    }
    void ImportingBillCalculation() {
        BillContainer[0] = AccommodationFee;
        BillContainer[1] = ServiceFee;
        BillContainer[2] = GrossFee;
    }
    void FinalOutput() {
        FinalOutputContainer[0] = userName;
        FinalOutputContainer[1] = String.valueOf(userRoomRate);
        FinalOutputContainer[2] = SessionAccomodation;
        FinalOutputContainer[3] = String.valueOf(SessionServiceRate);
        FinalOutputContainer[4] = String.valueOf(SessionRoomRate);
        FinalOutputContainer[5] = String.valueOf(SessionDaysStay);
        FinalOutputContainer[6] = String.valueOf(BillContainer[0]);
        FinalOutputContainer[7] = String.valueOf(BillContainer[1]);
        FinalOutputContainer[8] = String.valueOf(BillContainer[2]);
    }
    void PrintingFinalOutput() {
        System.out.println("\n\n-----------------Receipt-----------------");
        System.out.println(
                "\nGuest Name: " + FinalOutputContainer[0] +
                        "\nRoom Number: " + FinalOutputContainer[1] +
                        "\nAccommodation: " + FinalOutputContainer[2] +
                        "\nService Rate: " + FinalOutputContainer[3] +
                        "\nRoom Rate: " + FinalOutputContainer[4] +
                        "\nDays Stay: " + FinalOutputContainer[5] +
                        "\nAccommodation Fee: " + FinalOutputContainer[6] +
                        "\nAdd Service Fee: " + FinalOutputContainer[7] +
                        "\nGross Fee: " + FinalOutputContainer[8]
        );
        System.out.println("\n----------------------------------------");
    }
}