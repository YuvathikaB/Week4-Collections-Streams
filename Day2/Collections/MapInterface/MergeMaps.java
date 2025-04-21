package mapInterface;
import java.util.*;
public class MergeMaps {
	public static void main(String[] args) {
	      Scanner sc = new Scanner(System.in);
	      Map<String, Integer> map1 = new HashMap<>();
	      Map<String, Integer> map2 = new HashMap<>();
	      System.out.print("Enter number of entries for Map1 : ");
	      int n1 = sc.nextInt();
	      System.out.println("Enter key-value pairs (STR,INT) :");
	      for (int i = 0; i < n1; i++) {
	          String key = sc.next();
	          int value = sc.nextInt();
	          map1.put(key, value);
	      }
	      System.out.print("Enter number of entries for Map2 : ");
	      int n2 = sc.nextInt();
	      System.out.println("Enter key-value pairs (STR,INT) :");
	      for (int i = 0; i < n2; i++) {
	          String key = sc.next();
	          int value = sc.nextInt();
	          map2.put(key, value);
	      }
	      for (Map.Entry<String, Integer> entry : map2.entrySet()) {
	          map1.put(entry.getKey(), map1.getOrDefault(entry.getKey(), 0) + entry.getValue());
	      }
	      System.out.println();
	      System.out.println(map1);
	  }

}
