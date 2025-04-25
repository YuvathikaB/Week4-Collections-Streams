package streams;
import java.io.*;
import java.util.Scanner;
public class PipedStreams {
	   public static void main(String[] args) {
	       try {
	           PipedOutputStream pos = new PipedOutputStream();
	           PipedInputStream pis = new PipedInputStream(pos);
	           Scanner sc = new Scanner(System.in);
	           Thread writerThread = new Thread(() -> {
	               try (OutputStreamWriter writer = new OutputStreamWriter(pos)) {
	                   System.out.print("Enter a message: ");
	                   String input = sc.nextLine();
	                   writer.write(input);
	                   writer.flush();
	               } catch (IOException e) {
	                   System.out.println("Writer Error: " + e.getMessage());
	               }
	           });
	           Thread readerThread = new Thread(() -> {
	               try (InputStreamReader reader = new InputStreamReader(pis);
	                    BufferedReader br = new BufferedReader(reader)) {
	                   String line;
	                   while ((line = br.readLine()) != null) {
	                       System.out.println("Reader received: " + line);
	                   }
	               } catch (IOException e) {
	                   System.out.println("Reader Error: " + e.getMessage());
	               }
	           });
	           writerThread.start();
	           readerThread.start();
	           writerThread.join();
	           readerThread.join();
	       } catch (IOException | InterruptedException e) {
	           System.out.println("Error: " + e.getMessage());
	       }
	   }
}

