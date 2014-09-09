package com.deswaef.spring.examples.datajpa.user.repository;

import com.deswaef.spring.examples.datajpa.user.model.User;
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

    User findByNameAndPassword
            (
                @Param("name") String name,
                @Param("password") String password
            );

}
