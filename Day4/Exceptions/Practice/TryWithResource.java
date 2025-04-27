package practice;
import java.io.*;
import java.util.Scanner;
public class TryWithResource {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter file name: ");
       String fileName = sc.nextLine();
       try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
           String line = br.readLine();
           System.out.println("First line: " + line);
       } catch (IOException e) {
           System.out.println("Error reading file "+ e.getMessage());
       }
   }
}
