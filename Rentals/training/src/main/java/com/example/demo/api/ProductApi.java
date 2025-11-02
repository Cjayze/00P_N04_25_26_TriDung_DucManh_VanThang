package com.example.demo.api;

import com.example.demo.dao.ProductDAO;
import com.example.demo.model.Product;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductApi {
    private final ProductDAO dao = new ProductDAO();

    @GetMapping
    public List<Product> all() { return dao.getAll(); }

    @GetMapping("/{id}")
    public Product get(@PathVariable int id) { return dao.getById(id); }

    @PostMapping
    public String add(@RequestBody Product p) {
        dao.add(p);
        return "Product added";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Product p) {
        p.setId(id);
        dao.update(p);
        return "Product updated";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        dao.delete(id);
        return "Product deleted";
    }
}