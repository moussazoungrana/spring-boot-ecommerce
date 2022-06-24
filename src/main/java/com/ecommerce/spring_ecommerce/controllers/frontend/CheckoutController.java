package com.ecommerce.spring_ecommerce.controllers.frontend;

import com.ecommerce.spring_ecommerce.entities.Category;
import com.ecommerce.spring_ecommerce.entities.Order;
import com.ecommerce.spring_ecommerce.entities.OrderProduct;
import com.ecommerce.spring_ecommerce.entities.Product;
import com.ecommerce.spring_ecommerce.repositories.OrderProductRepository;
import com.ecommerce.spring_ecommerce.repositories.OrderRepository;
import com.ecommerce.spring_ecommerce.services.cart.Cart;
import com.ecommerce.spring_ecommerce.services.cart.CartItem;
import com.ecommerce.spring_ecommerce.services.cart.CartService;
import com.ecommerce.spring_ecommerce.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
@RequestMapping(value = "/checkout")
public class CheckoutController {
    @Autowired
    protected CartService cartService;

    @Autowired
    protected ProductService productService;

    @Autowired
    protected OrderRepository orderRepository;

    @Autowired
    protected OrderProductRepository orderProductRepository;


    @GetMapping(value = "")
    public String index(Model model) {
        model.addAttribute("cart", cartService.getCurrentCart());
        return "frontend/checkout";
    }



    @PostMapping("/store")
    public String store(@ModelAttribute Order order) {
        Cart cart = cartService.getCurrentCart();
        order.setTotalPrice(cart.getTotalPrice());
        order.setPaymentMethod("à la livraison");
       Order savedOrder = orderRepository.save(order);

        for (CartItem cartItem : cart.getCartItems()) {
            Product product = productService.findProductById(cartItem.getCode());
           orderProductRepository.save(new OrderProduct(cartItem.getQuantity(),cartItem.getSubTotal(),savedOrder,product));
        }

        return "redirect:/";
    }


}
