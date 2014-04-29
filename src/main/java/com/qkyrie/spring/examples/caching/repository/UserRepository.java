package com.qkyrie.spring.examples.caching.repository;

import com.qkyrie.spring.examples.caching.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * User: Quinten
 * Date: 29-4-2014
 * Time: 17:04
 *
 * @author Quinten De Swaef
 */
public interface UserRepository extends JpaRepository<User, Long>{
    User findUserByNameAndPassword(@Param("name") String name, @Param("password") String password);
}
