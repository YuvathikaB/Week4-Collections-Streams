package mapInterface;
import java.util.*;
public class InvertMap {
	 public static void main(String[] args) {
	      Scanner sc = new Scanner(System.in);
	      Map<String, Integer> original = new HashMap<>();
	      System.out.print("Enter number of entries : ");
	      int n = sc.nextInt();
	      System.out.println("Enter key-value pairs (String Integer):");
	      for (int i = 0; i < n; i++) {
	          String key = sc.next();
	          int value = sc.nextInt();
	          original.put(key, value);
	      }
	      Map<Integer, List<String>> inverted = new HashMap<>();
	      for (Map.Entry<String, Integer> entry : original.entrySet()) {
	          int val = entry.getValue();
	          String key = entry.getKey();
	          inverted.putIfAbsent(val, new ArrayList<>());
	          inverted.get(val).add(key);
	      }
	      System.out.println(inverted);
	  }
}

