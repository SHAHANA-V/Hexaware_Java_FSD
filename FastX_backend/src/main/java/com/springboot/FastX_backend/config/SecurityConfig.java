package com.springboot.FastX_backend.config;

import com.springboot.FastX_backend.service.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final MyUserDetailsService myUserDetailsService;

    @Bean
    public SecurityFilterChain defaultFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorize)->authorize
                        .requestMatchers(HttpMethod.POST,"/api/passenger/add").permitAll()
                        .anyRequest().permitAll()

                );
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }

}
