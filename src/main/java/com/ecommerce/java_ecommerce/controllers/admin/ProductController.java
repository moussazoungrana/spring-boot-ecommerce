package com.ecommerce.java_ecommerce.controllers.admin;

import com.ecommerce.java_ecommerce.entities.Media;
import com.ecommerce.java_ecommerce.entities.Product;
import com.ecommerce.java_ecommerce.repositories.MediaRepository;
import com.ecommerce.java_ecommerce.services.category.CategoryService;
import com.ecommerce.java_ecommerce.services.product.ProductService;
import com.ecommerce.java_ecommerce.services.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/admin/products")
public class ProductController {

    @Autowired
    protected ProductService productService;
    @Autowired
    protected CategoryService categoryService;

    @Autowired
    protected StorageService storageService;

    @Autowired
    protected MediaRepository mediaRepository;

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
    public String store(@ModelAttribute Product product, @RequestParam(required = false) String active,
                        @RequestParam(required = false) List<MultipartFile> files) {
        System.out.println(files);
        product.setActive(active != null);
        productService.saveProduct(product);
        return "redirect:/admin/products";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product, @RequestParam(required = false) String active,
                         @RequestParam(required = false) ArrayList<MultipartFile> files) {
     /*   String path = "images";
        for (MultipartFile file : files){
            String filename = storageService.store(file, path);
            Media media = new Media(filename);
            media.setProduct(product);
            mediaRepository.save(media);
            product.addMedia(media);
        }

      */
        product.setActive(active != null);
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
