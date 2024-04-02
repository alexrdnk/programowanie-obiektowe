
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RootsCalculator {

    public static List<Double> calculate_roots(double a, double b, double c) {
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    return new ArrayList<>(List.of(Double.POSITIVE_INFINITY));
                } else {
                    return new ArrayList<>(0);
                }
            } else {
                return new ArrayList<>(List.of(-c / b));
            }
        } else {
            var delta = b * b - 4 * a * c;
            if (delta > 0) {
                return new ArrayList<>(Arrays.asList(((-1 * b + Math.sqrt(delta)) / (2 * a)), ((-1 * b - Math.sqrt(delta)) / (2 * a))));
            } else if (delta < 0) {
                return new ArrayList<>(0);
            } else return new ArrayList<>(List.of(-b / (2 * a)));
        }
    }

    public static void main(String[] args) {
        List<Double> calc = calculate_roots(0, 0, 0);
        System.out.println(calc);

    }
}
