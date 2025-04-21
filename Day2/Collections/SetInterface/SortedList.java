package setInterface;
import java.util.*;
public class SortedList {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        HashSet<Integer> set = new HashSet<>();
	        System.out.print("Enter the number of elements: ");
	        int n = scanner.nextInt();
	        System.out.print("Enter " + n + " integers:");
	        for (int i = 0; i < n; i++) {
	            int num = scanner.nextInt();
	            set.add(num);
	        }
	        List<Integer> sortedList = new ArrayList<>(set);
	        Collections.sort(sortedList);
	        System.out.println(sortedList);
	        scanner.close();
	    }
}
