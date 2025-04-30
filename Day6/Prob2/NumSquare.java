package Problems2;
import java.util.Scanner;
@FunctionalInterface
interface SquareCalculator {
    int calculateSquare(int number);
    default void printResult(int number) {
        int result = calculateSquare(number);
        System.out.println("The square of " + number + " is: " + result);
    }
}
public class NumSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int input = scanner.nextInt();
        SquareCalculator square = (n) -> n * n;
        square.printResult(input);
    }
}
