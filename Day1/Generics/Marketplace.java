import java.util.*;
abstract class Category {
    abstract double getMinPrice();
    abstract double getMaxPrice();
    abstract String getCategoryName();
}
class BookCategory extends Category {
    public double getMinPrice() { return 5.0; }
    public double getMaxPrice() { return 100.0; }
    public String getCategoryName() { return "Book"; }
}
class ClothingCategory extends Category {
    public double getMinPrice() { return 10.0; }
    public double getMaxPrice() { return 500.0; }
    public String getCategoryName() { return "Clothing"; }
}
class GadgetCategory extends Category {
    public double getMinPrice() { return 50.0; }
    public double getMaxPrice() { return 2000.0; }
    public String getCategoryName() { return "Gadget"; }
}
class Product<T extends Category> {
    private String name;
    private double price;
    private T category;
    public Product(String name, double price, T category) {
        if (price < category.getMinPrice() || price > category.getMaxPrice()) {
            throw new IllegalArgumentException("Price for " + name + " must be between " + category.getMinPrice() + " and " + category.getMaxPrice());
        }
        this.name = name;
        this.price = price;
        this.category = category;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public T getCategory() {
        return category;
    }
    @Override
    public String toString() {
        return "Product Name: " + name + "\nPrice: " + price + "\nCategory: " + category.getCategoryName();
    }
}
class ProductCatalog {
    private List<Product<? extends Category>> products = new ArrayList<>();
    public <T extends Category> void addProduct(Product<T> product) {
        products.add(product);
    }
    public void displayCatalog() {
        for (Product<?> product : products) {
            System.out.println(product);
            System.out.println();
        }
    }
    public <T extends Category> void applyDiscount(Product<T> product, double percentage) {
        double currentPrice = product.getPrice();
        double newPrice = currentPrice - (currentPrice * percentage / 100);
        product.setPrice(newPrice);
        System.out.println("Discount Applied: " + product.getName() + "\nNew Price: " + product.getPrice());
    }
}
public class Marketplace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductCatalog catalog = new ProductCatalog();
        try {
            System.out.println("Enter Book Details:");
            System.out.print("Enter Book Name: ");
            String bookName = scanner.nextLine();
            System.out.print("Enter Book Price (5.0 - 100.0): ");
            double bookPrice = scanner.nextDouble();
            scanner.nextLine();
            Product<BookCategory> book = new Product<>(bookName, bookPrice, new BookCategory());
            catalog.addProduct(book);
            System.out.println();
            System.out.println("Enter Clothing Details:");
            System.out.print("Enter Clothing Name: ");
            String clothingName = scanner.nextLine();
            System.out.print("Enter Clothing Price (10.0 - 500.0): ");
            double clothingPrice = scanner.nextDouble();
            scanner.nextLine();
            Product<ClothingCategory> clothing = new Product<>(clothingName, clothingPrice, new ClothingCategory());
            catalog.addProduct(clothing);
            System.out.println();
            System.out.println("Enter Gadget Details:");
            System.out.print("Enter Gadget Name: ");
            String gadgetName = scanner.nextLine();
            System.out.print("Enter Gadget Price (50.0 - 2000.0): ");
            double gadgetPrice = scanner.nextDouble();
            scanner.nextLine();
            Product<GadgetCategory> gadget = new Product<>(gadgetName, gadgetPrice, new GadgetCategory());
            catalog.addProduct(gadget);
            System.out.println("\nProduct Catalog:");
            System.out.println();
            catalog.displayCatalog();
            System.out.print("\nEnter discount percentage to apply to all products: ");
            double discount = scanner.nextDouble();
            System.out.println();
            catalog.applyDiscount(book, discount);
            catalog.applyDiscount(clothing, discount);
            catalog.applyDiscount(gadget, discount);
            System.out.println("\nUpdated Product Catalog:");
            catalog.displayCatalog();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        scanner.close();
    }
}
