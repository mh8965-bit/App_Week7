import java.util.*;
import java.util.stream.*;

public class ProductDiscount {
    static double discount(double price) {
        return price > 1000 ? price * 0.80 : price;
    }

    public static void main(String[] args) {
        List<Double> prices = Arrays.asList(500.0, 1500.0, 2000.0, 800.0);

        List<Double> eligible = prices.stream()
            .filter(p -> p > 1000)
            .collect(Collectors.toList());

        List<Double> revised = prices.stream()
            .map(ProductDiscount::discount)
            .collect(Collectors.toList());

        System.out.println("Eligible products: " + eligible);
        System.out.println("Discounted prices: " + revised);
        System.out.println("Original prices: " + prices);
    }
}