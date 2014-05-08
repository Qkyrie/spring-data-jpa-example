package com.qkyrie.spring.examples.datajpa.user.repository;

import com.qkyrie.spring.examples.datajpa.AbstractRepositoryTest;
import com.qkyrie.spring.examples.datajpa.UserConfiguration;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;

import static org.fest.assertions.Assertions.assertThat;

@SpringApplicationConfiguration(classes = UserConfiguration.class)
public class UserRepositoryTest extends AbstractRepositoryTest{

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindAll_andProducerWorked() {
        assertThat(userRepository.findAll()).hasSize(1);
    }

    @Test
    public void findByNameAndPassword_andNoneFound() {
        assertThat(userRepository.findByNameAndPassword("mr.x", "weakpass")).isNull();
    }

    @Test
    public void findByNameAndPassword_andFoundOne() {
        assertThat(userRepository.findByNameAndPassword("Quinten", "SecretPassword")).isNotNull();
    }

}