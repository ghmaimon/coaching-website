package com.coaching.backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.authenticationProvider(authenticationProvider());
        auth
                .inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").authorities("auth1")
                .and()
                .withUser("ghmaimon").password(passwordEncoder().encode("maimon123")).roles("USER")
                .and()
                .withUser("modhik").password(passwordEncoder().encode("dahaka")).roles("MODHIK");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                /*.csrf().disable()
                .formLogin().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // filters:
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), this.userRepository))
                .authorizeRequests()
                .antMatchers("/api/login").permitAll()
                .antMatchers("/index.html").permitAll()
                .antMatchers("/api/services/hello").hasAnyRole("USER", "ADMIN")
                .antMatchers("/api/services/teacher/**").hasAuthority("auth1")
                .antMatchers("/api/services/hellos").hasRole("MANAGER")
                .antMatchers("/api/user/all").hasRole("ADMIN")
                .antMatchers("/api/user/withEmail").hasAnyRole("ADMIN MANAGER")
                .antMatchers("/api/user/withUserName").hasAnyRole("ADMIN MANAGER")
                .and()
                .httpBasic();*/
                .csrf().disable()
                .formLogin().disable()
                .authorizeRequests()
                .antMatchers("/api/account/create/client").permitAll()
                .and()
                .httpBasic();
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}