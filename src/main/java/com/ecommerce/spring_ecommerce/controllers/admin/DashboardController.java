package com.ecommerce.spring_ecommerce.controllers.admin;

import com.ecommerce.spring_ecommerce.services.product.ProductService;
import com.ecommerce.spring_ecommerce.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.net.URL;

@Controller
public class DashboardController {

    @Autowired
    protected ProductService productService;

    @Autowired
    protected UserService userService;

    @RequestMapping(value = "/admin")
    public String index(Model model) throws IOException {
        model.addAttribute("totalProduct", productService.getAll().size());
        model.addAttribute("totalUser", userService.getAll().size());
        return "admin/dashboard/index";
    }


}
