package com.qkyrie.spring.examples.caching.producer;

import com.qkyrie.spring.examples.caching.model.User;
import com.qkyrie.spring.examples.caching.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * User: Quinten
 * Date: 30-4-2014
 * Time: 14:24
 *
 * @author Quinten De Swaef
 */
@Component
public class UserProducer {
    private Log logger = LogFactory.getLog(UserProducer.class);

    private UserService userService;

    @Autowired
    public UserProducer(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void produceData() {
        findUsers();
        addOneUser();
        findUsers();
    }

    private void addOneUser() {
        logger.info("-> Adding new user now!");
        userService.addUser(new User("Quinten", "SecretPassword"));
    }

    private void findUsers() {
        logger.info("Trying to find all users.");
        List<User> allUsers = userService.getAllUsers();
        if(allUsers.isEmpty()) {
            logger.info("--No users found--");
        } else {
            for (User foundUser : allUsers) {
                logger.info(String.format("user with id %d and name %s found :)", foundUser.getId(), foundUser.getName()));
            }
        }
    }
}
