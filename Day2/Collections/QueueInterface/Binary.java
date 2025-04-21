package queueInterface;
import java.util.*;
public class Binary {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter no.of elements: ");
	        int N = sc.nextInt();
	        List<String> binaryList = generateBinaryNumbers(N);
	        System.out.println(binaryList);
	    }
	public static List<String> generateBinaryNumbers(int N) {
		    Queue<String> queue = new LinkedList<>();
	        List<String> result = new ArrayList<>();
	        queue.add("1");
	        for (int i = 0; i < N; i++) {
	            String current = queue.remove();
	            result.add("\"" + current + "\""); 
	            queue.add(current + "0");
	            queue.add(current + "1");
	        }
	        return result;
	    }
}