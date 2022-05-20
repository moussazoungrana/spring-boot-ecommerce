package com.ecommerce.java_ecommerce.controllers.admin;

import com.ecommerce.java_ecommerce.entities.Product;
import com.ecommerce.java_ecommerce.services.category.CategoryService;
import com.ecommerce.java_ecommerce.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/admin/products")
public class ProductController {

    @Autowired
    protected ProductService productService;

    @Autowired
    protected CategoryService categoryService;

    @GetMapping(value = "")
    public String index(Model model) {
        model.addAttribute("products", productService.getAll());
        return "admin/products/index";
    }

    @GetMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("product", new Product());
        return "admin/products/create";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/admin/products";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product) {
        productService.updateProduct(product);
        return "redirect:/admin/products";
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(Model model, @PathVariable long id) {
        Product product = productService.findProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getAll());
        return "admin/products/edit";
    }


}
