import java.util.ArrayList;
import java.util.List;

// Product class
class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}

// Cart Item class
class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }
}

// Shopping Cart class
class ShoppingCart {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        for (CartItem item : items) {
            if (item.getProduct().getId() == product.getId()) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new CartItem(product, quantity));
    }

    public void removeItem(int productId) {
        items.removeIf(item -> item.getProduct().getId() == productId);
    }

    public void viewCart() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        double total = 0;
        System.out.println("Your Cart:");
        for (CartItem item : items) {
            System.out.println(item.getProduct().getName() + " x " + item.getQuantity() +
                               " = " + item.getTotalPrice());
            total += item.getTotalPrice();
        }
        System.out.println("Total Amount: " + total);
    }
}

// Main class to demo
public class Main {
    public static void main(String[] args) {
        Product p1 = new Product(1, "T-shirt", 499.0);
        Product p2 = new Product(2, "Jeans", 999.0);
        Product p3 = new Product(3, "Sneakers", 1999.0);

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(p1, 2);
        cart.addItem(p2, 1);
        cart.addItem(p3, 1);

        cart.viewCart();

        cart.removeItem(2);
        System.out.println("\nAfter removing Jeans:");
        cart.viewCart();
    }
}
