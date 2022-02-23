package com.coaching.backend.security;

import com.coaching.backend.repository.UserRepository;
import com.coaching.backend.service.UserPrincipalDetailService;
import com.coaching.backend.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserPrincipalDetailService userPrincipalDetailService;
    private UserService userService;
    public SecurityConfiguration(UserPrincipalDetailService userPrincipalDetailService,
                                 UserService userService){
        this.userService = userService;
        this.userPrincipalDetailService = userPrincipalDetailService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .formLogin().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // filters:
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), this.userService))
                // Authorizations:
                .authorizeRequests()
                .antMatchers("/api/account/create/**").permitAll()
                .antMatchers("/api/account/list/**").hasRole("SUPERUSER")
                .antMatchers("/api/account/delete").authenticated()
                .antMatchers("/api/account/changePassword").authenticated()
                .antMatchers("/api/account/changePassword/**").permitAll()
                .antMatchers("/api/account/delete/**/**").hasRole("SUPERUSER")
                .antMatchers("/api/offer/add").hasAnyRole("SUPERUSER", "COACH")
                .antMatchers("/api/offer/**/**").permitAll()
                .antMatchers("/api/contract/**").hasRole("CLIENT");
        ;
    }

    @Bean
    AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(this.userPrincipalDetailService);
        return authenticationProvider;
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}