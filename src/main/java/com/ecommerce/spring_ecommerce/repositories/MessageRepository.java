package com.ecommerce.spring_ecommerce.repositories;

import com.ecommerce.spring_ecommerce.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}