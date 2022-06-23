package com.ecommerce.spring_ecommerce.repositories;

import com.ecommerce.spring_ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public Product findBySlug(String slug);
}
