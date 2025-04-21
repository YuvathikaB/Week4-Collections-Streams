package listInterface;
import java.util.LinkedList;
import java.util.Scanner;
public class NthFromEnd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<>();
        System.out.println("Enter elements of the linked list (type 'end' to stop):");
        while (true) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("end")) break;
            list.add(input);
        }
        System.out.print("Enter N : ");
        int N = scanner.nextInt();
        String result = findNthFromEnd(list, N);
        if (result != null) {
            System.out.println(result);
        } else {
            System.out.println("Invalid input");
        }
        scanner.close();
    }
    public static String findNthFromEnd(LinkedList<String> list, int N) {
        var first = list.listIterator();
        var second = list.listIterator();
        for (int i = 0; i < N; i++) {
            if (!first.hasNext()) return null;
            first.next();
        }
        while (first.hasNext()) {
            first.next();
            second.next();
        }
        if (second.hasNext()) {
            return second.next();
        } else {
            return null;
        }
    }
}