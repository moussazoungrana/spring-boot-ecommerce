package com.ecommerce.spring_ecommerce.services.product;

import com.ecommerce.spring_ecommerce.entities.Product;
import com.ecommerce.spring_ecommerce.repositories.ProductRepository;
import com.github.slugify.Slugify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product findProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product findProductBySlug(String slug) {
        return productRepository.findBySlug(slug);
    }

    public Product saveProduct(Product product) {
        Product saveProduct = productRepository.save(product);
        Slugify slg = new Slugify();
        saveProduct.setSlug(slg.slugify(saveProduct.getName()) + "-" + saveProduct.getId());
        return productRepository.save(saveProduct);
    }

    public Product updateProduct(Product product) {
        Slugify slg = new Slugify();
        product.setSlug(slg.slugify(product.getName()) + "-" + product.getId());
        return productRepository.save(product);
    }

    public Boolean deleteProductById(Long id) {
        if (this.findProductById(id) == null) {
            return false;
        }
        productRepository.deleteById(id);
        return true;
    }
}
