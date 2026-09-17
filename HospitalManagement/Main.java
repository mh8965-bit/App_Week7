import Doctor.Doctor;
import Patient.Patient;

public class Main {

    public static void main(String[] args) {

        Doctor d1 = new Doctor(
            101,
            "Dr. Arun",
            "Cardiologist",
            1000
        );

        Doctor d2 = new Doctor(
            102,
            "Dr. Priya",
            "Dermatologist",
            800
        );

        Patient p1 = new Patient(
            201,
            "Rahul",
            "Heart Problem",
            45
        );

        Patient p2 = new Patient(
            202,
            "Anu",
            "Skin Allergy",
            25
        );

        Patient p3 = new Patient(
            203,
            "Ravi",
            "Heart Problem",
            50
        );

        System.out.println("PATIENT DETAILS");

        System.out.println("\nPatient 1");
        p1.display();
        System.out.println("Treating Doctor: " + d1.getName());

        System.out.println("\nPatient 2");
        p2.display();
        System.out.println("Treating Doctor: " + d2.getName());

        System.out.println("\nPatient 3");
        p3.display();
        System.out.println("Treating Doctor: " + d1.getName());

        int patientsD1 = 2;
        int patientsD2 = 1;

        double totalD1 =
            patientsD1 * d1.getConsultationFee();

        double totalD2 =
            patientsD2 * d2.getConsultationFee();

        System.out.println("\nTOTAL CONSULTATION FEE");

        System.out.println(
            d1.getName() + ": Rs." + totalD1
        );

        System.out.println(
            d2.getName() + ": Rs." + totalD2
        );
    }
}