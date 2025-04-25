package streams;
import java.io.*;
import java.util.Scanner;
public class StudentDetails {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter file path to store data: ");
	        String filePath = sc.nextLine();
	        System.out.print("Enter number of students: ");
	        int n = Integer.parseInt(sc.nextLine());
	        try {
	            DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath));
	            for (int i = 0; i < n; i++) {
	                System.out.print("Enter roll number: ");
	                int roll = Integer.parseInt(sc.nextLine());
	                System.out.print("Enter name: ");
	                String name = sc.nextLine();
	                System.out.print("Enter GPA: ");
	                float gpa = Float.parseFloat(sc.nextLine());
	                dos.writeInt(roll);
	                dos.writeUTF(name);
	                dos.writeFloat(gpa);
	                System.out.println();
	            }
	            dos.close();
	            DataInputStream dis = new DataInputStream(new FileInputStream(filePath));
	            System.out.println("\nStored Student Details:");
	            while (dis.available() > 0) {
	                int roll = dis.readInt();
	                String name = dis.readUTF();
	                float gpa = dis.readFloat();
	                System.out.println("Roll: " + roll + ", Name: " + name + ", GPA: " + gpa);
	            }
	            dis.close();
	        } catch (IOException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }
}

