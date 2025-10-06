package com.example.demo.api;

import com.example.demo.dao.OrderDAO;
import com.example.demo.model.Order;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderApi {
    private final OrderDAO dao = new OrderDAO();

    @GetMapping
    public List<Order> all() { return dao.getAll(); }

    @GetMapping("/{id}")
    public Order get(@PathVariable int id) { return dao.getById(id); }

    @PostMapping
    public String add(@RequestBody Order o) { dao.add(o); return "Order added"; }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Order o) { o.setId(id); dao.update(o); return "Order updated"; }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) { dao.delete(id); return "Order deleted"; }
}