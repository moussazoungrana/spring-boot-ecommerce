package com.ecommerce.java_ecommerce.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = true, columnDefinition = "MEDIUMTEXT")
    private String slug;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String description;

    private boolean active = true;

    @ManyToMany(mappedBy = "categories")
    private List<Product> products;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "parent_id", nullable = true)
    private Category parent;

    @OneToMany(targetEntity = Category.class, mappedBy = "parent")
    private List<Category> children;


    public Category(String name, String slug, String description, boolean active) {
        this.name = name;
        this.slug = slug;
        this.description = description;
        this.active = active;
    }

    public Category() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }
}
