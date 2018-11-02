package com.seb.weeksevenchallenge.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfigration extends WebSecurityConfigurerAdapter {

    @Bean
    BCryptPasswordEncoder myBCryptEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/adddepartment").hasAuthority("USER")
                .antMatchers("/addemployee").hasAuthority("USER")
//                .antMatchers("/api").hasAuthority("APIUSER")
//                .antMatchers("/eitherusersoradmin").hasAnyAuthority("USER,ADMIN")
                .anyRequest().authenticated()
                .and().formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //COMMA SEPARATE AUTHORITIES (SEPARATE STRINGS)
        auth.inMemoryAuthentication().withUser("user").password(myBCryptEncoder().encode("password")).authorities("USER")
                .and().passwordEncoder(myBCryptEncoder());
//        auth.inMemoryAuthentication().withUser("anadmin").password(myBCryptEncoder().encode("adminpassword")).authorities("ADMIN")
//                .and().passwordEncoder(myBCryptEncoder());
    }
}
