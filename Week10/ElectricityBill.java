import java.util.*;
import java.util.stream.*;

public class ElectricityBill {
    static int bill(int units) {
        return units * 6;
    }

    public static void main(String[] args) {
        List<Integer> units = Arrays.asList(5, 12, 8, 15, 20);

        List<Integer> high = units.stream()
            .filter(u -> u > 10)
            .collect(Collectors.toList());

        List<Integer> costs = units.stream()
            .map(ElectricityBill::bill)
            .collect(Collectors.toList());

        int total = units.stream().reduce(0, Integer::sum);

        System.out.println("Consumption above 10: " + high);
        System.out.println("Daily costs: " + costs);
        System.out.println("Total consumption: " + total);
        System.out.println("Total bill: ₹" + bill(total));
    }
}