package com.ecommerce.spring_ecommerce.services.user;

import com.ecommerce.spring_ecommerce.entities.User;
import com.ecommerce.spring_ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Boolean deleteUser(Long id) {
        if (this.findUserById(id) == null) {
            return false;
        }
        userRepository.deleteById(id);
        return true;
    }
}
