package listInterface;
import java.util.*;
public class Frequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        List<String> items = new ArrayList<>();
        System.out.println("Enter " + n + " strings:");
        for (int i = 0; i < n; i++) {
            items.add(scanner.nextLine().toLowerCase());
        }
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String item : items) {
            if (frequencyMap.containsKey(item)) {
                int count = frequencyMap.get(item);
                frequencyMap.put(item, count + 1);
            } else {
                frequencyMap.put(item, 1);
            }
        }
        System.out.println(frequencyMap);
        scanner.close();
    }
}