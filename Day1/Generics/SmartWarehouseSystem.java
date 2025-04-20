import java.util.*;
abstract class WarehouseItem {
    private String name;
    private double price;
    public WarehouseItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public abstract void displayItemInfo();
}
class Electronics extends WarehouseItem {
    private String brand;
    public Electronics(String name, double price, String brand) {
        super(name, price);
        this.brand = brand;
    }
    @Override
    public void displayItemInfo() {
        System.out.println("Electronics: " + getName() + "\nPrice: " + getPrice() + "\nBrand: " + brand);
    }
}
class Groceries extends WarehouseItem {
    private String expiryDate;
    public Groceries(String name, double price, String expiryDate) {
        super(name, price);
        this.expiryDate = expiryDate;
    }
    @Override
    public void displayItemInfo() {
        System.out.println("Groceries: " + getName() + "\nPrice: " + getPrice() + "\nExpiry Date: " + expiryDate);
    }
}
class Furniture extends WarehouseItem {
    private String material;
    public Furniture(String name, double price, String material) {
        super(name, price);
        this.material = material;
    }
    @Override
    public void displayItemInfo() {
        System.out.println("Furniture: " + getName() + "\nPrice: " + getPrice() + "\nMaterial: " + material);
    }
}
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();
    public void addItem(T item) {
        items.add(item);
    }
    public List<T> getItems() {
        return items;
    }
    public void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            item.displayItemInfo();
            System.out.println();
        }
    }
}
public class SmartWarehouseSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();
        System.out.print("Enter number of Electronics items : ");
        int numElectronics = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numElectronics; i++) {
            System.out.print("Enter Electronics name : ");
            String name = scanner.nextLine();
            System.out.print("Enter Electronics price : ");
            double price = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Enter Electronics brand : ");
            String brand = scanner.nextLine();
            electronicsStorage.addItem(new Electronics(name, price, brand));
            System.out.println();
        }
        System.out.print("Enter number of Groceries items : ");
        int numGroceries = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numGroceries; i++) {
            System.out.print("Enter Groceries name : ");
            String name = scanner.nextLine();
            System.out.print("Enter Groceries price : ");
            double price = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Enter Groceries expiry date : ");
            String expiryDate = scanner.nextLine();
            groceriesStorage.addItem(new Groceries(name, price, expiryDate));
            System.out.println();
        }

        System.out.print("Enter number of Furniture items : ");
        int numFurniture = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numFurniture; i++) {
            System.out.print("Enter Furniture name : ");
            String name = scanner.nextLine();
            System.out.print("Enter Furniture price : ");
            double price = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Enter Furniture material : ");
            String material = scanner.nextLine();
            furnitureStorage.addItem(new Furniture(name, price, material));
            System.out.println();
        }
        System.out.println("Electronics Items :");
        System.out.println();
        electronicsStorage.displayItems(electronicsStorage.getItems());
        System.out.println();
        System.out.println("Groceries Items :");
        System.out.println();
        groceriesStorage.displayItems(groceriesStorage.getItems());
        System.out.println();
        System.out.println("Furniture Items :");
        System.out.println();
        furnitureStorage.displayItems(furnitureStorage.getItems());
        scanner.close();
    }
}
