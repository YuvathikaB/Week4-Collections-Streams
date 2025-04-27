package practice;
import java.util.Scanner;
public class MultipleCatch {
	   public static void main(String[] args) {
	       Scanner sc = new Scanner(System.in);
	       int[] arr = null;
	       System.out.print("Enter size of array : ");
	       int size = sc.nextInt();
	       if (size > 0) {
	           arr = new int[size];
	           System.out.print("Enter array elements : ");
	           for (int i = 0; i < size; i++) {
	               arr[i] = sc.nextInt();
	           }
	       }
	       System.out.print("Enter index to access : ");
	       int index = sc.nextInt();
	       try {
	           System.out.println("Value at index " + index + " : " + arr[index]);
	       } catch (ArrayIndexOutOfBoundsException e) {
	           System.out.println("Invalid index! ");
	       } catch (NullPointerException e) {
	           System.out.println("Array is not initialized!");
	       }
	   }
}
