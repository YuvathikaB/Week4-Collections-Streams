package setInterface;
import java.util.*;
public class Subset {
	  public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter the number of elements in Set1: ");
	        int n1 = scanner.nextInt();
	        HashSet<Integer> set1 = new HashSet<>();
	        System.out.print("Enter " + n1 + " integers for Set1:");
	        for (int i = 0; i < n1; i++) {
	            set1.add(scanner.nextInt());
	        }
	        System.out.print("Enter the number of elements in Set2: ");
	        int n2 = scanner.nextInt();
	        HashSet<Integer> set2 = new HashSet<>();
	        System.out.print("Enter " + n2 + " integers for Set2:");
	        for (int i = 0; i < n2; i++) {
	            set2.add(scanner.nextInt());
	        }
	        boolean isSubset = set2.containsAll(set1)|| set1.containsAll(set2);
	        System.out.println(isSubset);
	        scanner.close();
	    }
	}

