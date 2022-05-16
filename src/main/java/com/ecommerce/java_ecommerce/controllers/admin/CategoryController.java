package com.ecommerce.java_ecommerce.controllers.admin;

import com.ecommerce.java_ecommerce.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin/categories")
public class CategoryController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "")
    public String index(){
        return "admin/categories/index";
    }

    @RequestMapping(value = "/create")
    public String create() {
        return "admin/categories/create";
    }

    @RequestMapping(value = "/edit/{id}")
    public void edit(Model model, @PathVariable long id) {

    }


}
