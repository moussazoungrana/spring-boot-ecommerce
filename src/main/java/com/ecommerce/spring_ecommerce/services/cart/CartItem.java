package com.ecommerce.spring_ecommerce.services.cart;

import com.ecommerce.spring_ecommerce.entities.Product;

public class CartItem {

    private Long code;
    private Product product;
    private int quantity = 0;
    private float subTotal = 0;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public CartItem(Product product) {
        this.product = product;
    }

    public CartItem(){

    }

    public Long getCode() {
        return this.product.getId();
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSubTotal() {
        this.subTotal = this.product.getPrice() * this.quantity;
        return this.subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "code=" + this.getCode() +
                ", product=" + this.getProduct() +
                ", quantity=" + this.getQuantity() +
                ", subTotal=" + this.getSubTotal() +
                '}';
    }
}
