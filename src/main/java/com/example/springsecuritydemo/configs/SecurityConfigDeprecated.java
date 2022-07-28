//package com.example.springsecuritydemo.configs;
//
//import com.example.springsecuritydemo.authentication.jwt.JwtTokenFilter;
//import com.example.springsecuritydemo.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.servlet.http.HttpServletResponse;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfigDeprecated extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private JwtTokenFilter jwtTokenFilter;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(username -> userRepository.findByEmail(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found")));
//    }
//
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.exceptionHandling().authenticationEntryPoint(
//                (request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage())
//        );
//
//        http
//                .csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeRequests().antMatchers("/api/v1/auth/login").permitAll()
//                .anyRequest().authenticated();
//
//        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
//    }
//}
//
