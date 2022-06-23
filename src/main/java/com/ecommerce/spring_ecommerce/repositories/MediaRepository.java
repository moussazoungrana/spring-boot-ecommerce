package com.ecommerce.spring_ecommerce.repositories;

import com.ecommerce.spring_ecommerce.entities.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<Media, Long> {
}