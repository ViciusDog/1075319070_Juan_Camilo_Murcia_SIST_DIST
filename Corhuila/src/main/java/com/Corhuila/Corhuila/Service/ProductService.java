package com.Corhuila.Corhuila.Service;

import com.Corhuila.Corhuila.Entity.Product;
import com.Corhuila.Corhuila.Repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private IProductRepository iProductRepository;

    public List<Product> getAll() {
        return iProductRepository.findAll();
    }

    public Product findById(Integer id) {
        Product product = iProductRepository.findById(id).get();
        return product;
    }

    public Product addUpdate(Product product) {
        return iProductRepository.save(product);
    }

    public void deleteById(Integer id) {
        iProductRepository.deleteById(id);
    }
}
