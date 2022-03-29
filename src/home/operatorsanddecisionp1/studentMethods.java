package home.operatorsanddecisionp1;

public class studentMethods {
    private String studentName;
    private String studentSession;
    private String studentCourse;
    private double totalBalance;

    public studentMethods(String studentName, String studentSession, String studentCourse, double totalBalance) {
        this.studentName = studentName;
        this.studentSession = studentSession;
        this.studentCourse = studentCourse;
        this.totalBalance = totalBalance;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentSession() {
        return studentSession;
    }

    public String getStudentCourse() {
        return studentCourse;
    }

    public double getTotalBalance() {
        return totalBalance;
    }
}
