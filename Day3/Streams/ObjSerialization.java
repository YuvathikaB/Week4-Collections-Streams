package streams;
import java.io.*;
import java.util.*;
class Employee implements Serializable {
   int id;
   String name;
   String department;
   double salary;
   Employee(int id, String name, String department, double salary) {
       this.id = id;
       this.name = name;
       this.department = department;
       this.salary = salary;
   }
}
public class ObjSerialization {
	public static void main(String[] args) {
	       Scanner sc = new Scanner(System.in);
	       List<Employee> employees = new ArrayList<>();
	       System.out.print("Enter number of employees: ");
	       int n = Integer.parseInt(sc.nextLine());
	       for (int i = 0; i < n; i++) {
	           System.out.print("Enter Employee ID: ");
	           int id = Integer.parseInt(sc.nextLine());
	           System.out.print("Enter Employee Name: ");
	           String name = sc.nextLine();
	           System.out.print("Enter Employee Department: ");
	           String dept = sc.nextLine();
	           System.out.print("Enter Employee Salary: ");
	           double salary = Double.parseDouble(sc.nextLine());
	           employees.add(new Employee(id, name, dept, salary));
	           System.out.println();	       }
	       try {
	           ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.dat"));
	           oos.writeObject(employees);
	           oos.close();
	       } catch (IOException e) {
	           System.out.println("Error during serialization: " + e.getMessage());
	       }
	       try {
	           ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.dat"));
	           List<Employee> savedEmployees = (List<Employee>) ois.readObject();
	           ois.close();
	           System.out.println("\nSaved Employees:");
	           for (Employee emp : savedEmployees) {
	               System.out.println(emp.id + " " + emp.name + " " + emp.department + " " + emp.salary);
	           }
	       } catch (IOException | ClassNotFoundException e) {
	           System.out.println("Error during deserialization: " + e.getMessage());
	       }
	   }
}

