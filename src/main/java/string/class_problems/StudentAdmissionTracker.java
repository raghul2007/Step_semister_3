package string.class_problems;

public class StudentAdmissionTracker {

    static String university;
    static int admissionCount;

    static {
        university = "SRM Institute of Science and Technology";
        admissionCount = 0;

        System.out.println("University system initialized");
    }

    private String name;
    private int registerNumber;

    StudentAdmissionTracker(String name) {
        this.name = name;

        admissionCount++;

        registerNumber = 1000 + admissionCount;
    }

    void displayStudent() {

        System.out.println(
                registerNumber + " | " +
                name + " | " +
                university
        );
    }

    static void displayTotalAdmissions() {

        System.out.println(
                "Total Admissions: " +
                admissionCount
        );
    }

    public static void main(String[] args) {

        StudentAdmissionTracker s1 =
                new StudentAdmissionTracker("Ravi");

        StudentAdmissionTracker s2 =
                new StudentAdmissionTracker("Meera");

        s1.displayStudent();
        s2.displayStudent();

        StudentAdmissionTracker.displayTotalAdmissions();
    }
}