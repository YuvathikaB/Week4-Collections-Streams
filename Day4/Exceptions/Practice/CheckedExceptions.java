package practice;
import java.io.*;
import java.util.Scanner;
public class CheckedExceptions {
	public static void main(String[] args) {
	       Scanner sc = new Scanner(System.in);
	       System.out.print("Enter file name: ");
	       String fileName = sc.nextLine();
	       try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	           String line;
	           while ((line = reader.readLine()) != null) {
	               System.out.println(line);
	           }
	       } catch (IOException e) {
	           System.out.println("File not found");
	       }
	}
}
