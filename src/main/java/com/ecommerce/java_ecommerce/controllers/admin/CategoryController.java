package com.ecommerce.java_ecommerce.controllers.admin;

import com.ecommerce.java_ecommerce.entities.Category;
import com.ecommerce.java_ecommerce.services.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/admin/categories")
public class CategoryController {
    @Autowired
    protected CategoryService categoryService;

    @GetMapping(value = "")
    public String index(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return "admin/categories/index";
    }

    @GetMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("category", new Category());
        return "admin/categories/create";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute Category category) {
        categoryService.saveCategory(category);
        return "redirect:/admin/categories";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Category category) {
        categoryService.updateCategory(category);
        return "redirect:/admin/categories";
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(Model model, @PathVariable long id) {
        model.addAttribute("categories", categoryService.getAll());
        Category category = categoryService.findCategoryById(id);
        model.addAttribute("category", category);
        return "admin/categories/edit";
    }



}
