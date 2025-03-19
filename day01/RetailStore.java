
abstract class Product {

    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract void displayDetails();
}

class Fruit extends Product {

    private String season;

    public Fruit(String name, double price, int quantity, String season) {
        super(name, price, quantity);
        this.season = season;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    @Override
    public void displayDetails() {
        System.out.println("Fruit: " + getName() + ", Price: $" + getPrice() + ", Quantity: " + getQuantity() + ", Season: " + season);
    }
}

class Vegetable extends Product {

    private boolean isOrganic;

    public Vegetable(String name, double price, int quantity, boolean isOrganic) {
        super(name, price, quantity);
        this.isOrganic = isOrganic;
    }

    public boolean isOrganic() {
        return isOrganic;
    }

    public void setOrganic(boolean isOrganic) {
        this.isOrganic = isOrganic;
    }

    @Override
    public void displayDetails() {
        System.out.println("Vegetable: " + getName() + ", Price: $" + getPrice() + ", Quantity: " + getQuantity() + ", Organic: " + (isOrganic ? "Yes" : "No"));
    }
}

class Grocery extends Product {

    private String brand;

    public Grocery(String name, double price, int quantity, String brand) {
        super(name, price, quantity);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public void displayDetails() {
        System.out.println("Grocery: " + getName() + ", Price: $" + getPrice() + ", Quantity: " + getQuantity() + ", Brand: " + brand);
    }
}

public class RetailStore {

    private Product[] products;
    private int productCount;

    public RetailStore(int capacity) {
        products = new Product[capacity];
        productCount = 0;
    }

    public void addProduct(Product product) {
        if (productCount < products.length) {
            products[productCount++] = product;
        } else {
            System.out.println("Store is full, cannot add more products.");
        }
    }

    public void editProduct(String name, double newPrice, int newQuantity) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().equalsIgnoreCase(name)) {
                products[i].setPrice(newPrice);
                products[i].setQuantity(newQuantity);
                System.out.println("Product updated successfully.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void deleteProduct(String name) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().equalsIgnoreCase(name)) {
                // Shift products to the left to fill the gap
                for (int j = i; j < productCount - 1; j++) {
                    products[j] = products[j + 1];
                }
                products[--productCount] = null;
                System.out.println("Product deleted successfully.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void displayProducts() {
        if (productCount == 0) {
            System.out.println("No products available.");
        } else {
            for (int i = 0; i < productCount; i++) {
                products[i].displayDetails();
            }
        }
    }

    public static void main(String[] args) {
        RetailStore store = new RetailStore(5);

        store.addProduct(new Fruit("Apple", 1.5, 50, "Winter"));
        store.addProduct(new Vegetable("Carrot", 0.8, 100, true));
        store.addProduct(new Grocery("Rice", 20.0, 10, "Golden Harvest"));

        System.out.println("Initial Products:");
        store.displayProducts();

        System.out.println("\nEditing 'Apple'...");
        store.editProduct("Apple", 2.0, 60);

        System.out.println("\nProducts after editing:");
        store.displayProducts();

        System.out.println("\nDeleting 'Carrot'...");
        store.deleteProduct("Carrot");

        System.out.println("\nProducts after deletion:");
        store.displayProducts();
    }
}
