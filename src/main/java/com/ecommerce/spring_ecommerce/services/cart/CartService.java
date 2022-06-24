package com.ecommerce.spring_ecommerce.services.cart;

import com.ecommerce.spring_ecommerce.entities.Product;

public interface CartService {

    public Cart getCurrentCart();

    public void removeCurrentCart();

    public void add(Product product, int quantity);
}
