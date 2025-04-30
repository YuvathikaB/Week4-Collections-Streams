package Problems2;
import java.util.Scanner;
import java.util.function.Function;
public class FunctionInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter radius : ");
        double radius = scanner.nextDouble();
        Function<Double, Double> areaFunction = r -> Math.PI * r * r;
        double area = areaFunction.apply(radius);
        String result = String.format("Area of circle : %.2f", area);
        System.out.println(result);
    }
}
