import java.util.*;

public class APPEligibility {
    public static void main(String[] args) {
        Map<String, boolean[]> students = new LinkedHashMap<>();

        students.put("Arun", new boolean[]{true, true});
        students.put("Bala", new boolean[]{true, false});
        students.put("Charan", new boolean[]{true, true});
        students.put("Divya", new boolean[]{false, true});

        System.out.println("Eligible students:");

        students.forEach((name, result) -> {
            if (result[0] && result[1]) {
                System.out.println(name);
            }
        });
    }
}