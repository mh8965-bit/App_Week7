import java.util.*;
import java.util.stream.*;

public class Employee {
    public static void main(String[] args) {
        List<Integer> salary = Arrays.asList(30000, 45000, 35000, 50000);

        List<Integer> eligible = salary.stream()
            .filter(s -> s < 40000)
            .collect(Collectors.toList());

        List<Integer> revised = salary.stream()
            .map(s -> s < 40000 ? (int)(s * 1.10) : s)
            .collect(Collectors.toList());

        int total = revised.stream().reduce(0, Integer::sum);

        System.out.println("Eligible salaries: " + eligible);
        System.out.println("Revised salaries: " + revised);
        System.out.println("Total expenditure: " + total);
    }
}