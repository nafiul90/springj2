package com.nafiul.demo.configuration;

import com.nafiul.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) {
        try {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            builder
                    .inMemoryAuthentication()
                    .passwordEncoder(encoder)
                    .withUser("admin")
                    .password(encoder.encode("admin"))
                    .roles("admin");

            builder
                    .inMemoryAuthentication()
                    .passwordEncoder(encoder)
                    .withUser("nafiul")
                    .password(encoder.encode("ninad"))
                    .roles("customer");

            userService.getUsers().forEach(user -> {
                try {
                    builder
                            .inMemoryAuthentication()
                            .passwordEncoder(encoder)
                            .withUser(user.getUsername())
                            .password(encoder.encode(user.getPassword()))
                            .roles(user.getRole());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            // CW: read the users, passwords and roles from the db
            // and then load them up in memory

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http.csrf().disable();
////                .authorizeRequests()
////                .anyRequest().authenticated()
////                .and()
////                .httpBasic();;
//    }

}
