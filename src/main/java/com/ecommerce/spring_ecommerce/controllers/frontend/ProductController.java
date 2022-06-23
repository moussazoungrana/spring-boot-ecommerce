package com.ecommerce.spring_ecommerce.controllers.frontend;

import com.ecommerce.spring_ecommerce.entities.Product;
import com.ecommerce.spring_ecommerce.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller(value = "FrontProductController")
public class ProductController {

    @Autowired
    protected ProductService productService;

    @GetMapping(value = "/articles/{slug}")
    public String show(Model model, @PathVariable String slug) {
        Product product = productService.findProductBySlug(slug);
        model.addAttribute("product", product);
        return "frontend/products/show";
    }
}
