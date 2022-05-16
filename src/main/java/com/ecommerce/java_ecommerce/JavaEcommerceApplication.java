package com.ecommerce.java_ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JavaEcommerceApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(JavaEcommerceApplication.class, args);

      /*  ProductService productService = ctx.getBean(ProductService.class);
        productService.saveProduct(new product("produit test","produit-test","rfe",true,(float) 500.52,20)); */

    }

}
