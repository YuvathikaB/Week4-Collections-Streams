package Problems2;
import java.util.*;
public class OptionalHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        System.out.println("Enter integers ('stop' to finish):");
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                numbers.add(scanner.nextInt());
            } else {
                String input = scanner.next();
                if (input.equalsIgnoreCase("stop")) break;
            }
        }
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        if (max.isPresent()) {
            System.out.println("Maximum value: " + max.get());
        } else {
            System.out.println("The list is empty.");
        }
    }

}
