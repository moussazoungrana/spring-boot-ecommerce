package com.ecommerce.java_ecommerce.services.user;

import com.ecommerce.java_ecommerce.entities.Product;
import com.ecommerce.java_ecommerce.entities.User;

import java.util.List;

public interface UserService {
    public List<User> getAll();

    public User findUserById(Long id);

    public User saveUser(User user);

    public User updateUser(User user);


    public Boolean deleteUser(Long id);
}
