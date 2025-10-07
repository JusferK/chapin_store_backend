package com.chapinstore.config.security;

import com.chapinstore.entity.Administrator;
import com.chapinstore.entity.Customer;
import com.chapinstore.repository.AdministratorRepository;
import com.chapinstore.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@Configuration
public class SecurityBeanInjector {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AdministratorRepository administratorRepository;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationStrategy = new DaoAuthenticationProvider(userDetailsService());
        authenticationStrategy.setPasswordEncoder(passwordEncoder());

        return authenticationStrategy;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public UserDetailsService userDetailsService() {
        return (username) -> {

            Optional<Customer> findCustomer = customerRepository.findById(username);
            Optional<Administrator> findAdministrator = administratorRepository.findById(username);

            if (findCustomer.isPresent()) return findCustomer.get();
            if (findAdministrator.isPresent()) return findAdministrator.get();

            throw new EntityNotFoundException("No se encontro ningun usuario.");
        };
    }

}
