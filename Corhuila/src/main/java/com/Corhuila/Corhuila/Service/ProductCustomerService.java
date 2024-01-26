package com.Corhuila.Corhuila.Service;

import com.Corhuila.Corhuila.Entity.CustomerProduct;
import com.Corhuila.Corhuila.Entity.Product;
import com.Corhuila.Corhuila.Repository.ICustomerProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCustomerService {

    @Autowired
    private ICustomerProductRepository iCustomerProductRepository;

    public List<CustomerProduct> getAll() {
        return iCustomerProductRepository.findAll();
    }

    public CustomerProduct findById(Integer id) {
        CustomerProduct product = iCustomerProductRepository.findById(id).get();
        return product;
    }

    public CustomerProduct addUpdate(CustomerProduct customerProduct) {
        return iCustomerProductRepository.save(customerProduct);
    }

    public void deleteById(Integer id) {
        iCustomerProductRepository.deleteById(id);
    }
}
