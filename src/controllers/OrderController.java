
import java.util.ArrayList;
import java.util.List;

public class OrderController {
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
        System.out.println("✅ Added: " + order);
    }

    public void listOrders() {
        System.out.println("📜 Order List:");
        for (Order o : orders) System.out.println(o);
    }

    public void updateOrder(int id, int newCustomerId, int newProductId, int newQty) {
        for (Order o : orders) {
            if (o.getId() == id) {
                o.setCustomerId(newCustomerId);
                o.setProductId(newProductId);
                o.setQuantity(newQty);
                System.out.println("✏️ Updated: " + o);
                return;
            }
        }
        System.out.println("⚠️ Order id=" + id + " not found!");
    }

    public void deleteOrder(int id) {
        orders.removeIf(o -> o.getId() == id);
        System.out.println("🗑️ Deleted order id=" + id);
    }
}
