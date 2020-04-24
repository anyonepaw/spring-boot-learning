package com.example.springboot.learning.repository;

import com.example.springboot.learning.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
