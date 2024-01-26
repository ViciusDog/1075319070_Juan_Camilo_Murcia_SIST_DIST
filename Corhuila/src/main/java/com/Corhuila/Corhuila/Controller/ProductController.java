package com.Corhuila.Corhuila.Controller;

import com.Corhuila.Corhuila.Entity.Customer;
import com.Corhuila.Corhuila.Entity.Product;
import com.Corhuila.Corhuila.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/Product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    private Product findById(@PathVariable Integer id) {
        return productService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Product save(@RequestBody Product product) {
        return productService.addUpdate(product);
    }

    @PutMapping("/{id}")
    public Product update(@RequestBody Product customer, @PathVariable Integer id) {
        if (productService.findById(id) == null) return new Product();
        return productService.addUpdate(customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        productService.deleteById(id);
    }
}
