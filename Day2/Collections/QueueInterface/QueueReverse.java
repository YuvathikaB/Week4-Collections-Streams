package queueInterface;
import java.util.*;
public class QueueReverse {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        System.out.print("Enter the number of elements in the queue: ");
        int n = scanner.nextInt();
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            queue.add(scanner.nextInt());
        }
        System.out.println("Original Queue: " + queue);
        reverse(queue);
        System.out.println("Reversed Queue: " + queue);
        scanner.close();
    }
    public static void reverse(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }
        int item = queue.remove();
        reverse(queue);
        queue.add(item);
    }
}
