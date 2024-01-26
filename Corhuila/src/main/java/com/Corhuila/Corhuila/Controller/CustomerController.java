package com.Corhuila.Corhuila.Controller;

import com.Corhuila.Corhuila.Entity.Customer;
import com.Corhuila.Corhuila.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    private Customer findById(@PathVariable Integer id) {
        return customerService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Customer save(@RequestBody Customer customer) {
        return customerService.addUpdate(customer);
    }

    @PutMapping("/{id}")
    public Customer update(@RequestBody Customer customer, @PathVariable Integer id) {
        if (customerService.findById(id) == null) return new Customer();
        return customerService.addUpdate(customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        customerService.deleteById(id);
    }

}
