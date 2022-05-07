package com.ecommerce.java_ecommerce.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin/products")
public class ProductController {

    @RequestMapping(value = "/create")
    public String create() {
        return "admin/products/create";
    }


}
