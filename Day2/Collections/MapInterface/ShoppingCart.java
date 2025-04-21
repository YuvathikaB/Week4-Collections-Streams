package mapInterface;
import java.util.*;
public class ShoppingCart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Double> productPrices = new HashMap<>();
        LinkedHashMap<String, Integer> cartItems = new LinkedHashMap<>();
        System.out.print("Enter number of products : ");
        int numProducts = sc.nextInt();
        sc.nextLine();
        System.out.println();
        for (int i = 0; i < numProducts; i++) {
            System.out.print("Enter product name : ");
            String product = sc.nextLine();
            System.out.print("Enter product price : ");
            double price = sc.nextDouble();
            sc.nextLine();
            productPrices.put(product, price);
            System.out.println();
        }
        System.out.print("Enter number of items in the cart : ");
        int numItems = sc.nextInt();
        sc.nextLine();
        System.out.println();
        for (int i = 0; i < numItems; i++) {
            System.out.print("Enter product name for cart : ");
            String product = sc.nextLine();
            System.out.print("Enter quantity for " + product + " : ");
            int quantity = sc.nextInt();
            sc.nextLine();
            cartItems.put(product, quantity);
            System.out.println();
        }
        double totalCost = 0;
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();
            double price = productPrices.get(product);
            double cost = price * quantity;
            totalCost += cost;
        }
        TreeMap<Double, List<String>> sortedByPrice = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            String product = entry.getKey();
            double price = productPrices.get(product);
            sortedByPrice.putIfAbsent(price, new ArrayList<>());
            sortedByPrice.get(price).add(product);
        }
        System.out.println("Items in order added : ");
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();
            double price = productPrices.get(product);
            System.out.println("product - " + product + " quantity - " + quantity+" price - " + price);
        }
        System.out.println();
        System.out.println("Items sorted by price : ");
        for (Map.Entry<Double, List<String>> entry : sortedByPrice.entrySet()) {
            for (String product : entry.getValue()) {
                System.out.println(product + " : " + entry.getKey());
            }
        }
        System.out.println();
        System.out.println("Total cost : " + totalCost);
    }
}
