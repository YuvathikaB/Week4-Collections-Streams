package setInterface;
import java.util.*;
public class EqualSet {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        System.out.print("Enter the number of elements for Set 1:");
        int n1 = sc.nextInt();
        System.out.print("Enter the elements:");
        for (int i = 0; i < n1; i++) {
            set1.add(sc.nextInt());
        }
        System.out.print("Enter the number of elements for Set 2:");
        int n2 = sc.nextInt();
        System.out.print("Enter the elements:");
        for (int i = 0; i < n2; i++) {
            set2.add(sc.nextInt());
        }
        System.out.println(set1.equals(set2));
    }
}

