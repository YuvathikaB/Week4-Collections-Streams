package streams;
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
public class ImgToByteArr {
	public static void main(String[] args) {
	       Scanner sc = new Scanner(System.in);
	       System.out.print("Enter source image path: ");
	       String srcPath = sc.nextLine();
	       System.out.print("Enter destination image path: ");
	       String destPath = sc.nextLine();
	       try {
	           FileInputStream fis = new FileInputStream(srcPath);
	           ByteArrayOutputStream baos = new ByteArrayOutputStream();
	           byte[] buffer = new byte[4096];
	           int bytes;
	           while ((bytes = fis.read(buffer)) != -1) {
	               baos.write(buffer, 0, bytes);
	           }
	           byte[] imgBytes = baos.toByteArray();
	           fis.close();
	           baos.close();
	           ByteArrayInputStream bais = new ByteArrayInputStream(imgBytes);
	           FileOutputStream fos = new FileOutputStream(destPath);
	           while ((bytes = bais.read(buffer)) != -1) {
	               fos.write(buffer, 0, bytes);
	           }
	           bais.close();
	           fos.close();
	           FileInputStream fis1 = new FileInputStream(srcPath);
	           FileInputStream fis2 = new FileInputStream(destPath);
	           byte[] original = fis1.readAllBytes();
	           byte[] copy = fis2.readAllBytes();
	           fis1.close();
	           fis2.close();
	           if (Arrays.equals(original, copy)) {
	               System.out.println("The files are identical.");
	           } else {
	               System.out.println("The files are not identical.");
	           }
	       } catch (IOException e) {
	           System.out.println("Error: " + e.getMessage());
	       }
	   }
}
