package com.ecommerce.spring_ecommerce.services.message;


import com.ecommerce.spring_ecommerce.entities.Message;

import java.util.List;

public interface MessageService {

    public List<Message> getAll();

    public Message findMessageById(Long id);

    public Message saveMessage(Message message);


    public Boolean deleteMessageById(Long id);


}
