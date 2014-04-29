package com.qkyrie.spring.examples.caching.mvc;

import com.qkyrie.spring.examples.caching.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: Quinten
 * Date: 29-4-2014
 * Time: 17:02
 *
 * @author Quinten De Swaef
 */
@RequestMapping("/")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    public String index() {
        return "";
    }

}
