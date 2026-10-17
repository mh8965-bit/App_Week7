import java.util.*;

public class EmployeePromotion {
    public static void main(String[] args) {
        String[] names = {"Ravi", "Priya", "Kumar", "Meena"};
        int[] experience = {6, 3, 8, 7};
        boolean[] training = {true, true, false, true};
        int[] rating = {5, 4, 5, 4};

        System.out.println("Eligible employees:");

        for (int i = 0; i < names.length; i++) {
            if (experience[i] >= 5 &&
                training[i] &&
                rating[i] >= 4) {
                System.out.println(names[i]);
            }
        }
    }
}