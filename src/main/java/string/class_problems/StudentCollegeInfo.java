package string.class_problems;

public class StudentCollegeInfo {

    String name;
    double attendance;

    static String collegeName =
            "SRM Institute of Science and Technology";

    static int studentCount = 0;

    StudentCollegeInfo(
            String name,
            double attendance) {

        this.name = name;
        this.attendance = attendance;

        studentCount++;
    }

    static void printCollegeInfo() {

        System.out.println(collegeName);

        System.out.println(
                "Students created: " +
                studentCount
        );
    }

    public static void main(String[] args) {

        StudentCollegeInfo s1 =
                new StudentCollegeInfo(
                        "Ravi", 85
                );

        StudentCollegeInfo s2 =
                new StudentCollegeInfo(
                        "Anitha", 90
                );

        System.out.println(
                studentCount +
                " Student objects created"
        );

        StudentCollegeInfo.printCollegeInfo();
    }
}