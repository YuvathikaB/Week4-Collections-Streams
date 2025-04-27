package problems;
import java.io.*;
import java.util.*;
public class FileProcessor {
    public void processFiles(List<String> filePaths) {
        for (String path : filePaths) {
            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + path);
            }
        }
    }
    public static void main(String[] args) {
        List<String> files = Arrays.asList("file1.txt", "file2.txt", "file3.txt");
        FileProcessor processor = new FileProcessor();
        processor.processFiles(files);
    }
}
