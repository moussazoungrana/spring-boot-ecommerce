package com.ecommerce.spring_ecommerce.services.cart;

import com.ecommerce.spring_ecommerce.entities.Product;

import java.util.ArrayList;
import java.util.Objects;

public class Cart {

    private float totalPrice = 0;
    private int totalQuantity = 0;
    private ArrayList<CartItem> cartItems;

    public Cart() {
        this.totalPrice = 0;
        this.totalQuantity = 0;
        this.cartItems = new ArrayList<>();
    }

    public float getTotalPrice() {
        this.totalPrice = 0;
        for (CartItem cartItem : this.cartItems) {
            this.totalPrice = this.totalPrice + cartItem.getSubTotal();
        }
        return this.totalPrice;
    }

    public float getTotalQuantity() {
        this.totalQuantity = 0;
        for (CartItem cartItem : this.cartItems) {
            this.totalQuantity = this.totalQuantity + cartItem.getQuantity();
        }
        return this.totalQuantity;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void addProduct(Product product, int quantity) {
        CartItem cartItem = this.findCardItemByCode(product.getId());
        if (cartItem == null) {
            cartItem = new CartItem(product, quantity);
            this.cartItems.add(cartItem);
        }else {
            this.updateProduct(product, cartItem.getQuantity() + quantity);
        }

    }

    public void updateProduct(Product product, int quantity) {
        CartItem cartItem = this.findCardItemByCode(product.getId());
        assert cartItem != null : "Vide";
        if (quantity <= 0) {
            this.cartItems.remove(cartItem);
        }else {
            cartItem.setQuantity(quantity);
        }


    }

    public void removeProduct(Product product) {
        CartItem cartItem = this.findCardItemByCode(product.getId());
        if (cartItem != null) {
            this.cartItems.remove(cartItem);
        }
    }

    public CartItem findCardItemByCode(Long code) {
        for (CartItem cartItem : this.cartItems) {
            if (Objects.equals(cartItem.getCode(), code)) {
                return cartItem;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalPrice=" + this.getTotalPrice() +
                ", totalQuantity=" + this.getTotalQuantity() +
                ", cartItems=" + this.getCartItems() +
                '}';
    }
}
