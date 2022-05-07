package com.ecommerce.java_ecommerce.repositories;

import com.ecommerce.java_ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
