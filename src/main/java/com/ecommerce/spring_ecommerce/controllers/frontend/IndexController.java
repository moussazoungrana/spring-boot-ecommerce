package com.ecommerce.spring_ecommerce.controllers.frontend;

import com.ecommerce.spring_ecommerce.services.cart.CartService;
import com.ecommerce.spring_ecommerce.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    protected ProductService productService;
    @Autowired
    protected CartService cartService;

    @RequestMapping(value = "/")
    public String home(Model model) {
        cartService.getCurrentCart();
        model.addAttribute("products", productService.getAll());
        return "frontend/home";
    }
}
