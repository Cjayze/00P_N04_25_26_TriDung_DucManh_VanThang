package com.example.demo.web;

import com.example.demo.dao.ProductDAO;
import com.example.demo.dao.CustomerDAO;
import com.example.demo.dao.OrderDAO;
import com.example.demo.dao.UserDAO;
import com.example.demo.model.Product;
import com.example.demo.model.Customer;
import com.example.demo.model.Order;
import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    private final ProductDAO productDAO = new ProductDAO();
    private final CustomerDAO customerDAO = new CustomerDAO();
    private final OrderDAO orderDAO = new OrderDAO();
    private final UserDAO userDAO = new UserDAO();

    @GetMapping("/")
    public String index() { return "index"; }

    // Products UI
    @GetMapping("/products")
    public String products(Model model) {
        model.addAttribute("products", productDAO.getAll());
        model.addAttribute("productForm", new Product());
        return "product-list";
    }

    @PostMapping("/products")
    public String addProduct(@ModelAttribute Product product) {
        productDAO.add(product);
        return "redirect:/products";
    }

    @PostMapping("/products/update")
    public String updateProduct(@ModelAttribute Product product) {
        productDAO.update(product);
        return "redirect:/products";
    }

    @PostMapping("/products/delete")
    public String deleteProduct(@RequestParam int id) {
        productDAO.delete(id);
        return "redirect:/products";
    }

    // Customers UI
    @GetMapping("/customers")
    public String customers(Model model) {
        model.addAttribute("customers", customerDAO.getAll());
        model.addAttribute("customerForm", new Customer());
        return "customer-list";
    }

    @PostMapping("/customers")
    public String addCustomer(@ModelAttribute Customer customer) {
        customerDAO.add(customer);
        return "redirect:/customers";
    }

    @PostMapping("/customers/update")
    public String updateCustomer(@ModelAttribute Customer customer) {
        customerDAO.update(customer);
        return "redirect:/customers";
    }

    @PostMapping("/customers/delete")
    public String deleteCustomer(@RequestParam int id) {
        customerDAO.delete(id);
        return "redirect:/customers";
    }

    // Orders UI
    @GetMapping("/orders")
    public String orders(Model model) {
        model.addAttribute("orders", orderDAO.getAll());
        model.addAttribute("orderForm", new Order());
        model.addAttribute("products", productDAO.getAll());
        model.addAttribute("customers", customerDAO.getAll());
        return "order-list";
    }

    @PostMapping("/orders")
    public String addOrder(@ModelAttribute Order order) {
        orderDAO.add(order);
        return "redirect:/orders";
    }

    @PostMapping("/orders/delete")
    public String deleteOrder(@RequestParam int id) {
        orderDAO.delete(id);
        return "redirect:/orders";
    }

    // Users UI
    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userDAO.getAll());
        model.addAttribute("userForm", new User());
        return "user-list";
    }

    @PostMapping("/users")
    public String addUser(@ModelAttribute User user) {
        userDAO.add(user);
        return "redirect:/users";
    }

    @PostMapping("/users/delete")
    public String deleteUser(@RequestParam String email) {
        userDAO.deleteByEmail(email);
        return "redirect:/users";
    }
}