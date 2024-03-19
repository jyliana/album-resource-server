package com.apps.ws.clients.albumresourceserver.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig {

  @Bean
  public SecurityFilterChain configure(HttpSecurity http) throws Exception {
    JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
    jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());

    http.authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.GET, "/albums/**")
                    .hasRole("developer")
                    .anyRequest().authenticated())
            .oauth2ResourceServer(
                    oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter)));

    return http.build();
  }


}
