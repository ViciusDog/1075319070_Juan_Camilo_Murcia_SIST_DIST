package com.Corhuila.Corhuila.Repository;

import com.Corhuila.Corhuila.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {
}
