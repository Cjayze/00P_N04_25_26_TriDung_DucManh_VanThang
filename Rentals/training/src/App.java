// public class App {
//     public static void main(String[] args) throws Exception {
//         System.out.println("Hello, World!");

//         System.out.println("=== Run Practice 3 ===");
//         TestUser.run();
//         TestTime.run();
//         TestRecursion.run();
//     }
// }
// import controllers.ProductController;
// import models.Product;



// import controllers.*;
// import models.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ProductController productCtrl = new ProductController();
        CustomerController customerCtrl = new CustomerController();
        OrderController orderCtrl = new OrderController();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Product CRUD");
            System.out.println("2. Customer CRUD");
            System.out.println("3. Order CRUD");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    productMenu(productCtrl, sc);
                    break;
                case 2:
                    customerMenu(customerCtrl, sc);
                    break;
                case 3:
                    orderMenu(orderCtrl, sc);
                    break;
                case 4:
                    System.out.println("👋 Exit!");
                    sc.close();
                    return;
                default:
                    System.out.println("⚠️ Invalid choice!");
            }
        }
    }

    // ================= PRODUCT =================
    static void productMenu(ProductController ctrl, Scanner sc) {
        System.out.println("\n--- PRODUCT MENU ---");
        System.out.println("1. Add Product");
        System.out.println("2. List Products");
        System.out.println("3. Update Product");
        System.out.println("4. Delete Product");
        System.out.print("Choose: ");
        int ch = sc.nextInt(); sc.nextLine();

        switch (ch) {
            case 1:
                System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                System.out.print("Name: "); String name = sc.nextLine();
                System.out.print("Price: "); double price = sc.nextDouble();
                ctrl.addProduct(new Product(id, name, price));
                break;
            case 2:
                ctrl.listProducts();
                break;
            case 3:
                System.out.print("ID to update: "); id = sc.nextInt(); sc.nextLine();
                System.out.print("New Name: "); name = sc.nextLine();
                System.out.print("New Price: "); price = sc.nextDouble();
                ctrl.updateProduct(id, name, price);
                break;
            case 4:
                System.out.print("ID to delete: "); id = sc.nextInt();
                ctrl.deleteProduct(id);
                break;
        }
    }

    // ================= CUSTOMER =================
    static void customerMenu(CustomerController ctrl, Scanner sc) {
        System.out.println("\n--- CUSTOMER MENU ---");
        System.out.println("1. Add Customer");
        System.out.println("2. List Customers");
        System.out.println("3. Update Customer");
        System.out.println("4. Delete Customer");
        System.out.print("Choose: ");
        int ch = sc.nextInt(); sc.nextLine();

        switch (ch) {
            case 1:
                System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                System.out.print("Name: "); String name = sc.nextLine();
                System.out.print("Email: "); String email = sc.nextLine();
                ctrl.addCustomer(new Customer(id, name, email));
                break;
            case 2:
                ctrl.listCustomers();
                break;
            case 3:
                System.out.print("ID to update: "); id = sc.nextInt(); sc.nextLine();
                System.out.print("New Name: "); name = sc.nextLine();
                System.out.print("New Email: "); email = sc.nextLine();
                ctrl.updateCustomer(id, name, email);
                break;
            case 4:
                System.out.print("ID to delete: "); id = sc.nextInt();
                ctrl.deleteCustomer(id);
                break;
        }
    }

    // ================= ORDER =================
    static void orderMenu(OrderController ctrl, Scanner sc) {
        System.out.println("\n--- ORDER MENU ---");
        System.out.println("1. Add Order");
        System.out.println("2. List Orders");
        System.out.println("3. Update Order");
        System.out.println("4. Delete Order");
        System.out.print("Choose: ");
        int ch = sc.nextInt(); sc.nextLine();

        switch (ch) {
            case 1:
                System.out.print("Order ID: "); int id = sc.nextInt();
                System.out.print("Customer ID: "); int cid = sc.nextInt();
                System.out.print("Product ID: "); int pid = sc.nextInt();
                System.out.print("Quantity: "); int qty = sc.nextInt();
                ctrl.addOrder(new Order(id, cid, pid, qty));
                break;
            case 2:
                ctrl.listOrders();
                break;
            case 3:
                System.out.print("Order ID to update: "); id = sc.nextInt();
                System.out.print("New Customer ID: "); cid = sc.nextInt();
                System.out.print("New Product ID: "); pid = sc.nextInt();
                System.out.print("New Quantity: "); qty = sc.nextInt();
                ctrl.updateOrder(id, cid, pid, qty);
                break;
            case 4:
                System.out.print("Order ID to delete: "); id = sc.nextInt();
                ctrl.deleteOrder(id);
                break;
        }
    }
}
