package Problems1;
import java.util.*;
import java.util.stream.Collectors;
class Sale {
    String productId;
    int quantity;
    double price;
    public Sale(String productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
    public String getProductId() {
        return productId;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }
}
class ProductSales {
    String productId;
    int totalQuantity;
    double totalRevenue;
    public ProductSales(String productId, int totalQuantity, double totalRevenue) {
        this.productId = productId;
        this.totalQuantity = totalQuantity;
        this.totalRevenue = totalRevenue;
    }
    public String getProductId() {
        return productId;
    }
    public int getTotalQuantity() {
        return totalQuantity;
    }
    public double getTotalRevenue() {
        return totalRevenue;
    }
    public String toString() {
        return "productId : " + productId + " - Qty: " + totalQuantity + ", Revenue: " + totalRevenue;
    }
}
public class SalesAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Sale> sales = new ArrayList<>();
        System.out.print("Enter number of sales records: ");
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for sale " + (i + 1) + ":");
            System.out.print("Product ID: ");
            String productId = scanner.nextLine();
            System.out.print("Quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            System.out.print("Price: ");
            double price = Double.parseDouble(scanner.nextLine());
            sales.add(new Sale(productId, quantity, price));
            System.out.println();
        }
        List<ProductSales> topProducts = sales.stream()
                .collect(Collectors.groupingBy(Sale::getProductId))
                .entrySet().stream()
                .map(entry -> {
                    String productId = entry.getKey();
                    List<Sale> productSales = entry.getValue();
                    int totalQty = productSales.stream().mapToInt(Sale::getQuantity).sum();
                    double totalRev = productSales.stream().mapToDouble(s -> s.getQuantity() * s.getPrice()).sum();
                    return new ProductSales(productId, totalQty, totalRev);
                })
                .filter(p -> p.getTotalQuantity() > 10)
                .sorted(Comparator.comparingDouble(ProductSales::getTotalRevenue).reversed())
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("Top 5 Products by Total Revenue :\n");
        if (topProducts.isEmpty()) {
            System.out.println("No products matches the criteria.");
        } else {
            topProducts.forEach(System.out::println);
        }
    }
}
