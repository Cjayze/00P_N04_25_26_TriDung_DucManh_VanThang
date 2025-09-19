
import java.util.ArrayList;
import java.util.List;

public class CustomerController {
    private List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println(" Added: " + customer);
    }

    public void listCustomers() {
        System.out.println(" Customer List:");
        for (Customer c : customers) System.out.println(c);
    }

    public void updateCustomer(int id, String newName, String newEmail) {
        for (Customer c : customers) {
            if (c.getId() == id) {
                c.setName(newName);
                c.setEmail(newEmail);
                System.out.println(" Updated: " + c);
                return;
            }
        }
        System.out.println(" Customer id=" + id + " not found!");
    }

    public void deleteCustomer(int id) {
        customers.removeIf(c -> c.getId() == id);
        System.out.println(" Deleted customer id=" + id);
    }
}
