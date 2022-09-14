package com.sypialnia.domain.web.config;

// public class SecurityConfiguration extends WebSecurityAdapter {
//  @Override
//  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    super.configure(auth);
//  }
// }

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class WebSecurityConfig {

  private static final String[] WHITE_LIST_URLS = {
    "/", "/register", "/resendVerificationToken", "/registrationConfirm"
  };

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(11);
  }

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
        .cors()
        .and()
        .csrf()
        .disable()
        .authorizeRequests()
        .antMatchers(WHITE_LIST_URLS)
        .permitAll();
    return httpSecurity.build();
  }
}
