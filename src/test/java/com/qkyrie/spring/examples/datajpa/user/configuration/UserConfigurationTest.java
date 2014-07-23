package com.qkyrie.spring.examples.datajpa.user.configuration;

import com.qkyrie.spring.examples.datajpa.UserConfiguration;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * User: Quinten
 * Date: 8-5-2014
 * Time: 10:54
 *
 * @author Quinten De Swaef
 */
public class UserConfigurationTest {

    @Test
    public void bootstrapsApplication() {
        new AnnotationConfigApplicationContext(UserConfiguration.class);
    }
}
