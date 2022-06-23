package com.ecommerce.spring_ecommerce.controllers.admin;

import com.ecommerce.spring_ecommerce.entities.Media;
import com.ecommerce.spring_ecommerce.entities.Product;
import com.ecommerce.spring_ecommerce.repositories.MediaRepository;
import com.ecommerce.spring_ecommerce.services.category.CategoryService;
import com.ecommerce.spring_ecommerce.services.product.ProductService;
import com.ecommerce.spring_ecommerce.services.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/admin/products")
public class ProductController {

    private static final String uploadPath = "src/main/resources/static/uploads/products";
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
        Product saveProduct = productService.saveProduct(product);
        for (MultipartFile file : files){
            if (!file.isEmpty()){
                String filename = storageService.store(file, uploadPath);
                Media media = new Media(filename);
                media.setProduct(saveProduct);
                mediaRepository.save(media);
            }
        }
        return "redirect:/admin/products";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product, @RequestParam(required = false) String active,
                         @RequestParam(required = false) ArrayList<MultipartFile> files) {
        product.setActive(active != null);
      Product saveProduct =   productService.updateProduct(product);
        for (MultipartFile file : files){
            if (!file.isEmpty()){
                String filename = storageService.store(file, uploadPath);
                Media media = new Media(filename);
                media.setProduct(saveProduct);
                mediaRepository.save(media);
            }
        }
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
