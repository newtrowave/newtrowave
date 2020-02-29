package com.kostars.newtroshop.config.auth;

import com.kostars.newtroshop.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                    .authorizeRequests()
                    .antMatchers("/", "/img/**",  "/css/**", "/images/**", "/js/**", "/lib/**", "/style.css", "/fonts/**", "/loginpage", "/api/user/**").permitAll()
                    .antMatchers("/**").hasRole(Role.ADMIN.name())
                    .anyRequest().authenticated()
                .and()
                    .logout()
                        .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()
                     .defaultSuccessUrl("/", true)
                        .userInfoEndpoint()
                            .userService(customOAuth2UserService);
    }
}