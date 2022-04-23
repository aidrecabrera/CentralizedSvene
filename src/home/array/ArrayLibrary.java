package home.array;

import java.util.Scanner;

public class ArrayLibrary {
    Scanner mainScanner = new Scanner(System.in);
    String[] AvailableAccommodations = {
            "Office Room",
            "Family Room",
            "Sports Room",
    };
    double[] CurrentRoomRates = {
            900.00,
            750.00,
            650.00,
            825.00
    };
    String SessionAccomodation;
    double SessionRoomRate;
    int SessionDaysStay;
    double AccommodationFee, ServiceFee, GrossFee;
    double[] BillContainer = new double[8];
    void Name() {
        String userName = mainScanner.nextLine();
        while ((!mainScanner.hasNext("[A-Za-z]+")) || (userName.length() > 20)) {
            System.out.println("Invalid input! Try again.");
            userName = mainScanner.nextLine();
        }
        System.out.println("Hi, " + userName);
    }
    void DaysStay() {
        SessionDaysStay = mainScanner.nextInt();
        while ((SessionDaysStay < 2) || (SessionDaysStay > 30)) {
            System.out.println("We only allow the amount of days stay from 2 to 30 days. Please re-input!");
            SessionDaysStay = mainScanner.nextInt();
        }
    }
    void AccomodationLogic() {
        int userAccommodation = mainScanner.nextInt();
        SessionAccomodation = AvailableAccommodations[userAccommodation-1];
    }
    void RoomRateLogic() {
        int userRoomRate = mainScanner.nextInt();
        SessionRoomRate = CurrentRoomRates[userRoomRate-1];
    }
    void OverallCalculation() {
        AccommodationFee = SessionRoomRate * SessionDaysStay;
        ServiceFee = AccommodationFee * (ServiceFee/100);
        GrossFee = AccommodationFee + ServiceFee;
    }
    void ImportingOverall() {
        BillContainer[0] = AccommodationFee;
        BillContainer[1] = ServiceFee;
        BillContainer[2] = ServiceFee;
    }
}
