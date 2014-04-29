package com.qkyrie.spring.examples.caching.model;

/**
 * User: Quinten
 * Date: 11-4-2014
 * Time: 11:10
 *
 * @author Quinten De Swaef
 */
public class User {
    private Long id;
    private String name;
    private String password;

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
}
