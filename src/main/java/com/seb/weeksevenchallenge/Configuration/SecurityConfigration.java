package com.seb.weeksevenchallenge.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfigration extends WebSecurityConfigurerAdapter {

    @Bean
    BCryptPasswordEncoder myBCryptEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll()

                .antMatchers("/**").hasAnyAuthority("USER,APIUSER")
                .antMatchers("/api/**").hasAuthority("APIUSER")
                .and().formLogin()
        .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
        http.headers().frameOptions().disable().and().csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().withUser("user").password(myBCryptEncoder().encode("password")).authorities("USER")
                .and().passwordEncoder(myBCryptEncoder());
        auth.inMemoryAuthentication().withUser("apiuser").password(myBCryptEncoder().encode("password")).authorities("APIUSER")
                .and().passwordEncoder(myBCryptEncoder());
    }
}
