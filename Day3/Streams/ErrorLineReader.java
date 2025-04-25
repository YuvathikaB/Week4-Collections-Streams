package streams;
import java.io.*;
import java.util.Scanner;
public class ErrorLineReader {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter the file path: ");
       String filePath = sc.nextLine();
       try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
           String line;
           while ((line = reader.readLine()) != null) {
               if (line.toLowerCase().contains("error")) {
                   System.out.println(line);
               }
           }
       } catch (IOException e) {
           System.out.println("Error reading file: " + e.getMessage());
       }
   }
}

