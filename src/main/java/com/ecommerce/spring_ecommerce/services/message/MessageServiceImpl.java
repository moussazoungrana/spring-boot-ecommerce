package com.ecommerce.spring_ecommerce.services.message;

import com.ecommerce.spring_ecommerce.entities.Message;
import com.ecommerce.spring_ecommerce.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    @Override
    public Message findMessageById(Long id) {
        return messageRepository.findById(id).orElse(null);
    }

    @Override
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Boolean deleteMessageById(Long id) {
        if (this.findMessageById(id) == null) {
            return false;
        }
        messageRepository.deleteById(id);
        return true;
    }
}
