package com.ecommerce.java_ecommerce.controllers.admin;

import com.ecommerce.java_ecommerce.services.product.ProductService;
import com.ecommerce.java_ecommerce.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

    @Autowired
    protected ProductService productService;

    @Autowired
    protected UserService userService;

    @RequestMapping(value = "/admin")
    public String index(Model model) {
        model.addAttribute("totalProduct", productService.getAll().size());
        model.addAttribute("totalUser", userService.getAll().size());
        return "admin/dashboard/index";
    }


}
