package com.coursework.clothesstore.services;

import com.coursework.clothesstore.models.User;
import com.coursework.clothesstore.models.Product;
import com.coursework.clothesstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void update(User user) {
        List<Product> productlist1 = user.getProductList();
        List<Product> productlist = (userRepository.findByUsername(user.getUsername())).getProductList();
        productlist1.addAll(productlist);
        user.setProductList(productlist1);

        userRepository.save(user);
    }
}
