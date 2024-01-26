package com.Corhuila.Corhuila.Controller;

import com.Corhuila.Corhuila.Entity.CustomerProduct;
import com.Corhuila.Corhuila.Entity.Product;
import com.Corhuila.Corhuila.Service.ProductCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/CustomerProduct")
public class ProductServiceController {
    @Autowired
    private ProductCustomerService productCustomerService;

    @GetMapping
    public List<CustomerProduct> getAll() {
        return productCustomerService.getAll();
    }

    @GetMapping("/{id}")
    private CustomerProduct findById(@PathVariable Integer id) {
        return productCustomerService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CustomerProduct save(@RequestBody CustomerProduct customerProduct) {
        return productCustomerService.addUpdate(customerProduct);
    }

    @PutMapping("/{id}")
    public CustomerProduct update(@RequestBody CustomerProduct customer, @PathVariable Integer id) {
        if (productCustomerService.findById(id) == null) return new CustomerProduct();
        return productCustomerService.addUpdate(customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        productCustomerService.deleteById(id);
    }
}
