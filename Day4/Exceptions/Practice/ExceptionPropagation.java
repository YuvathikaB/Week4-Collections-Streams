package practice;
import java.util.Scanner;
public class ExceptionPropagation {
	public static void method1(int numerator, int denominator) {
	       int result = numerator / denominator;
	       System.out.println("Result: " + result);
	   }
	   public static void method2(int numerator, int denominator) {
	       method1(numerator, denominator);
	   }
	   public static void main(String[] args) {
	       Scanner sc = new Scanner(System.in);
	       try {
	           System.out.print("Enter numerator: ");
	           int numerator = sc.nextInt();
	           System.out.print("Enter denominator: ");
	           int denominator = sc.nextInt();
	           method2(numerator, denominator);
	       } catch (ArithmeticException e) {
	           System.out.println("Handled exception in main");
	       }
	   }
}
