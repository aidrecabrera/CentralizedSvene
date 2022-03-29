package home.operatorsanddecisionp1;
public class immutableLibrary {
    String[] ssDataList = {"Morning", "Afternoon"};
    String[] crsDescriptionDataList = {"C++", "Java", "Visual Basic"};
    int[] crsFeeDataList = {7000, 8000, 9000};
    public String courseName;
    double courseFee;
    void cPlusPlus() {
        courseName = crsDescriptionDataList[0];
        courseFee = crsFeeDataList[0];
    }
    void java() {
        courseName = crsDescriptionDataList[1];
        courseFee = crsFeeDataList[1];
    }
    void visualBasic() {
        courseName = crsDescriptionDataList[2];
        courseFee = crsFeeDataList[2];
    }
}
