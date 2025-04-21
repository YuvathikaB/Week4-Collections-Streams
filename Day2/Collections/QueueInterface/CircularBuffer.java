package queueInterface;
import java.util.*;
public class CircularBuffer {
	int[] buffer;
	   int size, start, end, count;
	   public CircularBuffer(int capacity) {
	       buffer = new int[capacity];
	       size = capacity;
	       start = 0;
	       end = 0;
	       count = 0;
	   }
	   public void insert(int value) {
	       buffer[end] = value;
	       end = (end + 1) % size;
	       if (count < size) {
	           count++;
	       } else {
	           start = (start + 1) % size;
	       }
	   }
	   public List<Integer> getBuffer() {
	       List<Integer> result = new ArrayList<>();
	       for (int i = 0; i < count; i++) {
	           result.add(buffer[(start + i) % size]);
	       }
	       return result;
	   }
	   public static void main(String[] args) {
	       Scanner sc = new Scanner(System.in);
	       System.out.print("Enter buffer size : ");
	       int bufferSize = sc.nextInt();
	       CircularBuffer cb = new CircularBuffer(bufferSize);
	       System.out.print("Num of elements you want to insert : ");
	       int insertCount = sc.nextInt();
	       System.out.print("Enter " + insertCount + " elements : ");
	       for (int i = 0; i < insertCount; i++) {
	           int element = sc.nextInt();
	           cb.insert(element);
	       }
	       System.out.println(cb.getBuffer());
	   }
}
