package com.ecommerce.spring_ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringEcommerceApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringEcommerceApplication.class, args);

      /*  ProductService productService = ctx.getBean(ProductService.class);
        productService.saveProduct(new product("produit test","produit-test","rfe",true,(float) 500.52,20)); */

    }

}
