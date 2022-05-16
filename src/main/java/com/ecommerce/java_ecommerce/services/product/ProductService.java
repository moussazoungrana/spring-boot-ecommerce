package com.ecommerce.java_ecommerce.services.product;

import com.ecommerce.java_ecommerce.entities.Product;


import java.util.List;

public interface ProductService {

    public List<Product> getAll();

    public Product findProductById(Long id);

    public Product saveProduct(Product product);

    public Product updateProduct(Product product);


    public Boolean deleteProduct(Long id);
}