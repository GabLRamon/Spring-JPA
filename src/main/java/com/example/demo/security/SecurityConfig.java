package com.example.demo.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails gabriel = User.builder()
                .username("Gabriel")
                .password("{noop}123456")
                .roles("EMPLOYEE, MANAGER, ADMIN")
                .build();

        UserDetails marlon = User.builder()
                .username("marlon")
                .password("{noop}123456")
                .roles("EMPLOYEE, MANAGER")
                .build();

        UserDetails marilde = User.builder()
                .username("marilde")
                .password("{noop}123456")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails flavia = User.builder()
                .username("flavia")
                .password("{noop}123456")
                .roles("EMPLOYEE, MANAGER")
                .build();

        return new InMemoryUserDetailsManager(gabriel, marlon, marilde, flavia);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/estudantes").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/estudantes/{id}").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/estudantes").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/estudantes").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/estudantes").hasRole("ADMIN")


        );
        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
