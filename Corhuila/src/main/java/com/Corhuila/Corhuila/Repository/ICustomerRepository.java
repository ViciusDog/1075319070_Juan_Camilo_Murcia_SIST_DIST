package com.Corhuila.Corhuila.Repository;

import com.Corhuila.Corhuila.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
}
