import java.util.*;
import java.util.stream.*;

public class StudentMarks {
    public static void main(String[] args) {
        List<Integer> marks = Arrays.asList(45, 60, 75, 30, 90);

        List<Integer> passed = marks.stream()
            .filter(m -> m >= 50)
            .collect(Collectors.toList());

        List<Integer> grace = marks.stream()
            .map(m -> Math.min(m + 5, 100))
            .collect(Collectors.toList());

        int total = grace.stream()
            .reduce(0, Integer::sum);

        System.out.println("Passed students' marks: " + passed);
        System.out.println("Marks after grace: " + grace);
        System.out.println("Total marks: " + total);
    }
}