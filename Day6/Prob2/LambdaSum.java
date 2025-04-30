package Problems2;
import java.util.Scanner;
@FunctionalInterface
interface Adder {
    int add(int a, int b);
}
public class LambdaSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number 1 : ");
        int num1 = scanner.nextInt();
        System.out.print("Enter number 2 : ");
        int num2 = scanner.nextInt();
        Adder adder = (a, b) -> a + b;
        int result = adder.add(num1, num2);
        System.out.println("Sum: " + result);
    }
}

