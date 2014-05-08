package com.qkyrie.spring.examples.datajpa.user.service;

import com.qkyrie.spring.examples.datajpa.user.model.User;
import com.qkyrie.spring.examples.datajpa.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: Quinten
 * Date: 29-4-2014
 * Time: 17:04
 *
 * @author Quinten De Swaef
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }
}
