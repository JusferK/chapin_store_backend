package com.chapinstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ChapinStoreApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                SpringApplication.run(ChapinStoreApplication.class, args);

        PasswordEncoder encoder = context.getBean(PasswordEncoder.class);

        /*
        *
        * TEMPORAL HASTA QUE SE MANTENGA PERSISTENCIA REAL.
        *
        */

    }

}
