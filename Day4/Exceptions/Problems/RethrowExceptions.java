package problems;
import java.util.Scanner;
public class RethrowExceptions {
	public static int performDivision(int numerator, int denominator) {
	       if (denominator == 0) {
	           throw new ArithmeticException("Denominator is zero");
	       }
	       return numerator / denominator;
	   }
	   public static int calculate(int numerator, int denominator) {
	       try {
	           return performDivision(numerator, denominator);
	       } catch (ArithmeticException e) {
	           throw new ArithmeticException("Error in calculate : " + e.getMessage());
	       }
	   }
	   public static void main(String[] args) {
	       Scanner scanner = new Scanner(System.in);
	       System.out.print("Enter the numerator : ");
	       int numerator = scanner.nextInt();
	       System.out.print("Enter the denominator : ");
	       int denominator = scanner.nextInt();
	       try {
	           int result = calculate(numerator, denominator);
	           System.out.println("Result : " + result);
	       } catch (ArithmeticException e) {
	           System.out.println("Exception caught in main : " + e.getMessage());
	       }
	   }
}
