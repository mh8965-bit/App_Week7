import Student.Student;
import Course.Course;

public class Main {

    public static void main(String[] args) {

        Student s = new Student(101, "Meghanta", "CSE");

        Course c = new Course(
            "CS101",
            "Java Programming",
            4
        );

        System.out.println("STUDENT DETAILS");
        s.display();

        System.out.println();

        System.out.println("COURSE DETAILS");
        c.display();
    }
}