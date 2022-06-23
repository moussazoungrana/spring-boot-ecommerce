package com.ecommerce.spring_ecommerce.controllers.admin;

import com.ecommerce.spring_ecommerce.entities.Message;
import com.ecommerce.spring_ecommerce.services.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/admin/messages")
public class MessageController {

    @Autowired
    protected MessageService messageService;

    @GetMapping(value = "")
    public String index(Model model) {
        model.addAttribute("messages", messageService.getAll());
        return "admin/messages/index";
    }


    @GetMapping(value = "/{id}/show")
    public String show(Model model, @PathVariable long id) {
       Message message = messageService.findMessageById(id);
        model.addAttribute("message", message);
        return "admin/messages/show";
    }

    @GetMapping(value = "/{id}/delete")
    public String delete(Model model, @PathVariable long id) {
        messageService.deleteMessageById(id);
        return "admin/messages/index";
    }
}
