package com.VictorHugoBatista.personal_note_manager.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(
                authorize -> authorize
                    .requestMatchers("/api-docs").permitAll()
                    .requestMatchers("/swagger-ui/**").permitAll()
                    .requestMatchers("/v3/api-docs*/**").permitAll()
                    .requestMatchers(HttpMethod.POST, "/api/v1/user").permitAll()
                    .requestMatchers(HttpMethod.POST, "/api/v1/user/login").permitAll()
                    .anyRequest().authenticated());

        return http.build();
    }
}
