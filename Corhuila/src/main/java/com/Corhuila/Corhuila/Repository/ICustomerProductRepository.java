package com.Corhuila.Corhuila.Repository;

import com.Corhuila.Corhuila.Entity.CustomerProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerProductRepository extends JpaRepository<CustomerProduct, Integer> {
}
