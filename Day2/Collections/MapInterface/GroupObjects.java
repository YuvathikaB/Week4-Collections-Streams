package mapInterface;
import java.util.*;
public class GroupObjects {
	public static void main(String[] args) {
	      Scanner sc = new Scanner(System.in);
	      Map<String, List<String>> departmentMap = new HashMap<>();
	      System.out.print("Enter number of employees : ");
	      int n = sc.nextInt();
	      sc.nextLine();
	      System.out.println();
	      for (int i = 0; i < n; i++) {
	          System.out.print("Enter employee name : ");
	          String name = sc.nextLine();
	          System.out.print("Enter department : ");
	          String department = sc.nextLine();
	          departmentMap.putIfAbsent(department, new ArrayList<>());
	          departmentMap.get(department).add(name);
	          System.out.println();
	      }
	      for (Map.Entry<String, List<String>> entry : departmentMap.entrySet()) {
	          System.out.println(entry.getKey() + ": " + entry.getValue());
	      }
	  }
}
