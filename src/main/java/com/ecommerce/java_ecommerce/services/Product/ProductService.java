package com.ecommerce.java_ecommerce.services.Product;

import com.ecommerce.java_ecommerce.entities.Product;
import com.ecommerce.java_ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ProductService {

    public List<Product> getAll();

    public Product findProductById(Long id);

    public Product saveProduct(Product product);

    public Product updateProduct(Product product);


    public Boolean deleteProduct(Long id);
}
