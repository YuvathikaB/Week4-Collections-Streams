package listInterface;
import java.util.*;
public class RemoveDuplicate {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        List<Integer> inputList = new ArrayList<>();
        System.out.print("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            inputList.add(scanner.nextInt());
        }
        Set<Integer> seen = new HashSet<>();
        List<Integer> resultList = new ArrayList<>();
        for (Integer num : inputList) {
            if (!seen.contains(num)) {
                seen.add(num);
                resultList.add(num);
            }
        }
        System.out.println(resultList);
        scanner.close();
    }
}

