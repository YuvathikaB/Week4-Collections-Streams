package advanced;
import java.util.*;
import java.util.regex.*;
public class ExtractCurrency {
	public static void main(String[] args) {
	       Scanner scanner = new Scanner(System.in);
	       System.out.print("Enter text: ");
	       String text = scanner.nextLine();
	       String regex = "\\$?\\d+\\.\\d{2}";
	       Pattern pattern = Pattern.compile(regex);
	       Matcher matcher = pattern.matcher(text);
	       while (matcher.find()) {
	           System.out.println(matcher.group());
	       }
	}
}
