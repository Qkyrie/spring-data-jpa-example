package com.qkyrie.spring.examples.caching.service;

import com.qkyrie.spring.examples.caching.model.User;
import com.qkyrie.spring.examples.caching.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Quinten
 * Date: 29-4-2014
 * Time: 17:04
 *
 * @author Quinten De Swaef
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User authenticate(String name, String password) {
        return userRepository.findUserByNameAndPassword(name, password);
    }

}
