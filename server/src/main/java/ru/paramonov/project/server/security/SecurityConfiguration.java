package ru.paramonov.project.server.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import sun.security.util.Password;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.csrf().disable()
                .authorizeRequests().antMatchers("/login")
                .permitAll()
                .and()
                .authorizeRequests().antMatchers("/account_controller/accounts", "/card_controller/cards").hasAnyRole("ADMIN", "MANAGER")
                .and()
                .authorizeRequests().antMatchers("/account_controller/add_account", "/card_controller/add_cards").hasAnyRole("ADMIN")
                .and()
                .formLogin()
                .defaultSuccessUrl("/account_controller/accounts")
                .and()
                .logout()
                .logoutUrl("/logout");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
              return charSequence.toString().equals(s);
            }
        };
    }
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN")
                .and()
                .withUser("manager").password("manager").roles("MANAGER");
    }
}
