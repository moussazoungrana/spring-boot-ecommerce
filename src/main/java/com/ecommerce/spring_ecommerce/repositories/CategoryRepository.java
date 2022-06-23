package com.ecommerce.spring_ecommerce.repositories;

import com.ecommerce.spring_ecommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    public Category findBySlug(String slug);
}
