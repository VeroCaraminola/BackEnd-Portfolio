/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.vcc.Security;

import com.portfolio.vcc.Security.Service.UserDetailsImpl;
import com.portfolio.vcc.Security.jwt.JwtEntryPoint;
import com.portfolio.vcc.Security.jwt.JwtTokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor


public class WebSecurityConfig {
    
    final UserDetailsImpl userDetailsServiceImpl;
            
            private final JwtEntryPoint jwtEntryPoint;
                    private final PasswordEncoder passwordEncoder;
                            
                            @Bean
                            public JwtTokenFilter authenticationJwtTokenFilter() {
                            return new JwtTokenFilter();
                            
     }
                            AuthenticationManager authenticationManager;                                    
          @Bean
                  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                  AuthenticationManagerBuilder builder = http.getSharedObject(AuthenticationManagerBuilder.class);
                  builder.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder);
                  authenticationManager = builder.build();
                  http.authenticationManager(authenticationManager);
                  http.csrf().disable();
                  http.cors().disable();
                  http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                  
                  http.authorizeHttpRequests().requestMatchers("/auth/**").permitAll()
                          .requestMatchers("/**").permitAll()
                          .anyRequest().authenticated();
                  http.exceptionHandling().authenticationEntryPoint(jwtEntryPoint);
                  http.addFilterBefore (authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
                  return http.build();
                  
                  }
}
