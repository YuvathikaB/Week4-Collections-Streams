package listInterface;
import java.util.*;
public class Rotate {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter the number of elements: ");
	        int n = scanner.nextInt();
	        List<Integer> list = new ArrayList<>();
	        System.out.println("Enter " + n + " elements:");
	        for (int i = 0; i < n; i++) {
	            list.add(scanner.nextInt());
	        }
	        System.out.print("Enter the number of positions to rotate: ");
	        int k = scanner.nextInt();
	        k = k % n;
	        List<Integer> rotated = new ArrayList<>();
	        for (int i = k; i < n; i++) {
	            rotated.add(list.get(i));
	        }
	        for (int i = 0; i < k; i++) {
	            rotated.add(list.get(i));
	        }
	        System.out.println(rotated);
	        scanner.close();
	    }
	}
