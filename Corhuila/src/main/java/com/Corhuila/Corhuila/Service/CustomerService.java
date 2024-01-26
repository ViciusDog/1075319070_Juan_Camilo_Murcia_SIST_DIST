package com.Corhuila.Corhuila.Service;

import com.Corhuila.Corhuila.Entity.Customer;
import com.Corhuila.Corhuila.Repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    public List<Customer> getAll() {
        return iCustomerRepository.findAll();
    }

    public Customer findById(Integer id) {
        Customer customer = iCustomerRepository.findById(id).get();
        return customer;
    }

    public Customer addUpdate(Customer customer) {
        return iCustomerRepository.save(customer);
    }

    public void deleteById(Integer id) {
        iCustomerRepository.deleteById(id);
    }
}
