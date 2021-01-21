package com.example.cloudgateway.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfiguration {


    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {

        // Disable default security.
        http.httpBasic().disable();
        http.formLogin().disable();
        http.csrf().disable();
        http.logout().disable();

        // Disable authentication for `/auth/**` routes.
        http.authorizeExchange().pathMatchers("**").permitAll();

        return http.build();
    }
}