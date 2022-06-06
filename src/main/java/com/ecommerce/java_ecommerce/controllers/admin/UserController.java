package com.ecommerce.java_ecommerce.controllers.admin;

import com.ecommerce.java_ecommerce.entities.User;
import com.ecommerce.java_ecommerce.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/admin/users")
public class UserController {
    @Autowired
    protected UserService userService;

    @GetMapping(value = "")
    public String index(Model model) {
        model.addAttribute("users", userService.getAll());
        return "admin/users/index";
    }

    @GetMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "admin/users/create";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute User user, @RequestParam(required = false) String is_admin) {
        user.setAdmin(is_admin != null);
        userService.saveUser(user);
        return "redirect:/admin/users";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute User user, @RequestParam(required = false) String is_admin) {
        user.setAdmin(is_admin != null);
        userService.updateUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(Model model, @PathVariable long id) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "admin/users/edit";
    }


}
