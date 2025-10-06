
import java.util.ArrayList;
import java.util.List;

public class ProductController {
    private List<Product> products = new ArrayList<>();

    // CREATE
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("✅ Added: " + product);
    }

    // READ
    public void listProducts() {
        System.out.println("📦 Product List:");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    // UPDATE
    public void updateProduct(int id, String newName, double newPrice) {
        for (Product p : products) {
            if (p.getId() == id) {
                p.setName(newName);
                p.setPrice(newPrice);
                System.out.println("✏️ Updated: " + p);
                return;
            }
        }
        System.out.println("⚠️ Product with id=" + id + " not found!");
    }

    // DELETE
    public void deleteProduct(int id) {
        Product target = null;
        for (Product p : products) {
            if (p.getId() == id) {
                target = p;
                break;
            }
        }
        if (target != null) {
            products.remove(target);
            System.out.println("🗑️ Deleted: " + target);
        } else {
            System.out.println("⚠️ Product with id=" + id + " not found!");
        }
    }
}
