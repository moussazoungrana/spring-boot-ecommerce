package com.ecommerce.java_ecommerce;

import com.ecommerce.java_ecommerce.entities.Product;
import com.ecommerce.java_ecommerce.repositories.ProductRepository;
import com.ecommerce.java_ecommerce.services.Product.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JavaEcommerceApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(JavaEcommerceApplication.class, args);

      /*  ProductService productService = ctx.getBean(ProductService.class);
        productService.saveProduct(new Product("produit test","produit-test","rfe",true,(float) 500.52,20)); */

    }

}
