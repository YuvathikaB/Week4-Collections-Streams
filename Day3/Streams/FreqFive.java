package streams;
import java.io.*;
import java.util.*;
public class FreqFive {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String filePath = sc.nextLine();
        Map<String, Integer> wordCount = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        if (wordCount.containsKey(word)) {
                            wordCount.put(word, wordCount.get(word) + 1);
                        } else {
                            wordCount.put(word, 1);
                        }
                    }
                }
            }
            int totalWords = 0;
            for (int count : wordCount.values()) {
                totalWords += count;
            }
            System.out.println("Total number of words: " + totalWords);
            List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCount.entrySet());
            Collections.sort(sortedList, new Comparator<Map.Entry<String, Integer>>() {
                public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                    return b.getValue().compareTo(a.getValue());
                }
            });
            System.out.println("Top 5 most frequent words:");
            for (int i = 0; i < Math.min(5, sortedList.size()); i++) {
                System.out.println(sortedList.get(i).getKey() + " - " + sortedList.get(i).getValue());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}