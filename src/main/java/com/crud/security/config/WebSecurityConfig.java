package com.crud.security.config;

import com.crud.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

//@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)
@ComponentScan("com.crud.service")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Bean("authenticationManager")
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }

    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new MySimpleUrlAuthenticationSuccessHandler();
    }

    @Bean
    public AuthenticationFailureHandler myAuthenticationFailureHandler(){
        return new MySimpleUrlAuthenticationFailureHandler();
    }

    @Bean
    public LogoutSuccessHandler myLogoutSuccessHandler(){
        return new MySimpleLogoutSuccessHandler();
    }



    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("user").password("{noop}user").roles("USER");
//        auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN");
//        auth.inMemoryAuthentication().withUser("superadmin").password("{noop}superadmin").roles("SUPERADMIN");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
//                .anyRequest().authenticated()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/main/**").hasAnyRole("admin","user")
                .and()
                .authorizeRequests().antMatchers("/login**").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/loginAction")
                .successHandler(myAuthenticationSuccessHandler())
                .permitAll()
                .failureHandler(myAuthenticationFailureHandler())
                .permitAll()
//                .failureUrl("/error")
//                .permitAll()
//                .defaultSuccessUrl("/default",true)
                .and()
                .logout().logoutSuccessHandler(myLogoutSuccessHandler()).permitAll()
//                .logoutSuccessUrl("/login")
                .and()
                .exceptionHandling().accessDeniedPage("/accessDenied");
    }
}