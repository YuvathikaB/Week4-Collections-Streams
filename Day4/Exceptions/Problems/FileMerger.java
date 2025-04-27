package problems;
import java.io.*;
public class FileMerger {
   public static void main(String[] args) {
       String file1 = "file1.txt";
       String file2 = "file2.txt";
       String outputFile = "output.txt";
       try (
           BufferedReader reader1 = new BufferedReader(new FileReader(file1));
           BufferedReader reader2 = new BufferedReader(new FileReader(file2));
           BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
       ) {
           String line;
           while ((line = reader1.readLine()) != null) {
               writer.write(line);
               writer.newLine();
           }
           while ((line = reader2.readLine()) != null) {
               writer.write(line);
               writer.newLine();
           }
       } catch (IOException e) {
           System.out.println("An error occurred: " + e.getMessage());
       }
   }
}

