package listInterface;
import java.util.*;
public class ReverseList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();
        System.out.print("Enter " + n + " elements for ArrayList(:");
        for (int i = 0; i < n; i++) {
            arrayList.add(scanner.nextInt());
        }
        LinkedList<Integer> linkedList = new LinkedList<>(arrayList); 
        ArrayList<Integer> reversedArrayList = new ArrayList<>();
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            reversedArrayList.add(arrayList.get(i));
        }
        LinkedList<Integer> reversedLinkedList = new LinkedList<>();
        for (int i = linkedList.size() - 1; i >= 0; i--) {
            reversedLinkedList.add(linkedList.get(i));
        }
        System.out.println("Reversed ArrayList: " + reversedArrayList);
        System.out.println("Reversed LinkedList: " + reversedLinkedList);
        scanner.close();
    }
}
