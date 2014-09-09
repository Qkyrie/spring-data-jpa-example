package com.deswaef.spring.examples.datajpa.user.repository;

import com.deswaef.spring.examples.datajpa.UserConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.fest.assertions.Assertions.assertThat;

@SpringApplicationConfiguration(classes = UserConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class UserRepositoryTest {

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