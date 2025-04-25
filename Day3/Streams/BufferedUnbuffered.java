package streams;
import java.io.*;
import java.util.Scanner;
public class BufferedUnbuffered {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter source file path: ");
        String srcPath = sc.nextLine();
        System.out.print("Enter destination file path (unbuffered): ");
        String destUnbuffPath = sc.nextLine();
        System.out.print("Enter destination file path (buffered): ");
        String destBuffPath = sc.nextLine();
        copyUsingUnbuff(srcPath, destUnbuffPath);
        copyUsingBuff(srcPath, destBuffPath);
    }
    public static void copyUsingUnbuff(String src, String dest) {
        try {
            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(dest);
            byte[] buffer = new byte[4096];
            int bytesRead;
            long startTime = System.nanoTime();
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            long endTime = System.nanoTime();
            System.out.println("Unbuffered copy time: " + (endTime - startTime) / 1_000_000 + " ms");
            fis.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("Error in unbuffered copy: " + e.getMessage());
        }
    }
    public static void copyUsingBuff(String src, String dest) {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
            byte[] buffer = new byte[4096];
            int bytesRead;
            long startTime = System.nanoTime();
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            long endTime = System.nanoTime();
            System.out.println("Buffered copy time: " + (endTime - startTime) / 1_000_000 + " ms");
            bis.close();
            bos.close();
        } catch (IOException e) {
            System.out.println("Error in buffered copy: " + e.getMessage());
        }
    }
}

