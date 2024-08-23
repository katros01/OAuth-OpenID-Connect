package com.oauth.openIDConnect.oauth.openIDConnect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .anyRequest()
                .authenticated()
                .and()
                .oauth2Login()
                .and()
                .sessionManagement()
                .sessionFixation().migrateSession()
                .maximumSessions(1)
                .expiredUrl("/logout");
        ;
        return http.build();
    }
}
