package com.ecommerce.spring_ecommerce.controllers.frontend;

import com.ecommerce.spring_ecommerce.entities.Product;
import com.ecommerce.spring_ecommerce.services.cart.Cart;
import com.ecommerce.spring_ecommerce.services.cart.CartService;
import com.ecommerce.spring_ecommerce.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/cart")
public class CartController {
    @Autowired
    protected CartService cartService;

    @Autowired
    protected ProductService productService;


    @GetMapping(value = "")
    public String index(Model model) {
        model.addAttribute("cart", cartService.getCurrentCart());
        return "frontend/cart/index";
    }


    @GetMapping("/{code}/remove")
    public String remove(@PathVariable long code) {
        Product product = productService.findProductById(code);
        Cart cart = cartService.getCurrentCart();
        cart.removeProduct(product);
        return "redirect:/cart";
    }



    @PostMapping("/add")
    public String add(@RequestParam Long id, @RequestParam int quantity) {
        Product product = productService.findProductById(id);
        Cart cart = cartService.getCurrentCart();
        cart.addProduct(product, quantity);
        return "redirect:/articles/" + product.getSlug();
    }


}
