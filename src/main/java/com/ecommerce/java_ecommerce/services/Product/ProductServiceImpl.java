package com.ecommerce.java_ecommerce.services.Product;

import com.ecommerce.java_ecommerce.entities.Product;
import com.ecommerce.java_ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements ProductService{


    @Autowired
    private ProductRepository $productRepository;

    public List<Product> getAll() {
        return $productRepository.findAll();
    }

    public Product findProductById(Long id) {
        return $productRepository.findById(id).get();
    }

    public Product saveProduct(Product product) {
        return $productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        return $productRepository.save(product);
    }

    public Boolean deleteProduct(Long id) {
        if (this.findProductById(id) == null) {
            return false;
        }
        $productRepository.deleteById(id);
        return true;
    }
}
