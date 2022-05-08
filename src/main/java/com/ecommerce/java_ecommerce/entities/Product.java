package com.ecommerce.java_ecommerce.entities;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true, unique = true)
    private String slug;

    @Column(nullable = true)
    private String sku;

    @Column(nullable = false)
    private boolean active = true;

    @Column(nullable = false)
    private float price;

    @Column(nullable = false)
    private int quantity;


    public Product(String name, String slug, String sku, boolean active, float price, int quantity) {
        this.name = name;
        this.slug = slug;
        this.sku = sku;
        this.active = active;
        this.price = price;
        this.quantity = quantity;
    }

    public Product() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
