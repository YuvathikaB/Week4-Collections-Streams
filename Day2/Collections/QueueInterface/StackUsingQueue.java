package queueInterface;
import java.util.*;
public class StackUsingQueue {
	Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    int pop() {
        if (q1.isEmpty()) return -1;
        return q1.remove();
    }
    int top() {
        if (q1.isEmpty()) return -1;
        return q1.peek();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackUsingQueue stack = new StackUsingQueue();
        while (true) {
            System.out.println("\n1 - Push");
            System.out.println("2 - Pop");
            System.out.println("3 - Top");
            System.out.println("4 - Exit");
            System.out.print("Choose an operation: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int val = sc.nextInt();
                    stack.push(val);
                    break;
                case 2:
                    int popped = stack.pop();
                    System.out.println(popped == -1 ? "Stack is empty" : "Popped: " + popped);
                    break;
                case 3:
                    int top = stack.top();
                    System.out.println(top == -1 ? "Stack is empty" : "Top: " + top);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
