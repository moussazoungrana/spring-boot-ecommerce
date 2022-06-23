package com.ecommerce.spring_ecommerce.services.cart;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;


@Service
public class CartServiceImpl implements CartService {

    @Autowired
    ObjectFactory<HttpSession> httpSessionFactory;

    @Override
    public Cart getCurrentCart() {
        Cart cart = (Cart) this.httpSessionFactory.getObject().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            this.httpSessionFactory.getObject().setAttribute("cart", cart);
        }
        return cart;
    }

    @Override
    public void removeCurrentCart() {
        this.httpSessionFactory.getObject().removeAttribute("cart");
    }
}
