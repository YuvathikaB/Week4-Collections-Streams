package mapInterface;
import java.util.*;
public class MaxValueKey {
	public static void main(String[] args) {
	      Scanner sc = new Scanner(System.in);
	      Map<String, Integer> map = new HashMap<>();
	      System.out.print("Enter number of entries : ");
	      int n = sc.nextInt();
	      System.out.println("Enter key-value pairs (String Integer):");
	      for (int i = 0; i < n; i++) {
	          String key = sc.next();
	          int value = sc.nextInt();
	          map.put(key, value);
	      }
	      String maxKey = null;
	      int maxValue = Integer.MIN_VALUE;
	      for (Map.Entry<String, Integer> entry : map.entrySet()) {
	          if (entry.getValue() > maxValue) {
	              maxValue = entry.getValue();
	              maxKey = entry.getKey();
	          }
	      }
	      System.out.println();
	      System.out.println(maxKey);
	}

}
