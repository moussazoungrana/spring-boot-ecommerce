package com.ecommerce.spring_ecommerce.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true, unique = true, columnDefinition = "MEDIUMTEXT")
    private String slug;

    @Column(nullable = true)
    private String sku;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private boolean active = true;

    @Column(nullable = false)
    private float price;

    @Column(nullable = false)
    private int quantity;

    @ManyToMany(targetEntity = Category.class, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "category_products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Media> media;


    public Product(String name, String slug, String sku, String description, boolean active, float price, int quantity) {
        this.name = name;
        this.slug = slug;
        this.sku = sku;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void addCategory(Category category) {
        this.categories.add(category);
    }

    public List<Media> getMedia() {
        return media;
    }

    public void setMedia(List<Media> media) {
        this.media = media;
    }

    public void addMedia(Media media) {
        if (!this.media.contains(media)) {
            this.media.add(media);
        }
    }
}
