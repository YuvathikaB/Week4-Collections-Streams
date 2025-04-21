package mapInterface;
import java.util.*;
public class VotingSystem {
	public static void main(String[] args) {
	      Scanner sc = new Scanner(System.in);
	      HashMap<String, Integer> voteCount = new HashMap<>();
	      LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>();
	      System.out.print("Enter number of votes:");
	      int n = Integer.parseInt(sc.nextLine());
	      System.out.println("Enter candidate names for each vote:");
	      for (int i = 0; i < n; i++) {
	          String candidate = sc.nextLine();
	          voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
	          voteOrder.put(candidate, voteOrder.getOrDefault(candidate, 0) + 1);
	      }
	      System.out.println("\nVote Count (HashMap):");
	      for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
	          System.out.println(entry.getKey() + ": " + entry.getValue());
	      }
	      System.out.println("\nVote Order (LinkedHashMap):");
	      for (Map.Entry<String, Integer> entry : voteOrder.entrySet()) {
	          System.out.println(entry.getKey() + ": " + entry.getValue());
	      }
	      TreeMap<String, Integer> sortedVotes = new TreeMap<>(voteCount);
	      System.out.println("\nSorted Vote Count (TreeMap):");
	      for (Map.Entry<String, Integer> entry : sortedVotes.entrySet()) {
	          System.out.println(entry.getKey() + ": " + entry.getValue());
	      }
	}
}
