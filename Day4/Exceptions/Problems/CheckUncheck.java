package problems;
import java.util.Scanner;
class DataProcessingException extends Exception {
   public DataProcessingException(String message) {
       super(message);
   }
}
public class CheckUncheck {
	public void processData(int data) throws DataProcessingException {
	       if (data < 0) {
	           throw new DataProcessingException("Checked exception: Negative data not allowed");
	       }
	       if (data == 0) {
	           throw new IllegalArgumentException("Unchecked exception: Data cannot be zero");
	       }
	       System.out.println("Data processed successfully: " + data);
	   }
	   public static void main(String[] args) {
	       Scanner scanner = new Scanner(System.in);
	       CheckUncheck processor = new CheckUncheck();
	       System.out.print("Enter data: ");
	       int data = scanner.nextInt();
	       try {
	           processor.processData(data); 
	       } catch (DataProcessingException e) {
	           System.out.println("Caught checked exception: " + e.getMessage());
	       } catch (IllegalArgumentException e) {
	           System.out.println("Caught unchecked exception: " + e.getMessage());
	       }
	   }
}
