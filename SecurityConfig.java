package com.example.helpdesk.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf->csrf.disable())
            .authorizeHttpRequests(auth->auth
                .requestMatchers("/","/index.html","/lost.html","/Found.html","/contact.html","/AgentLogin.html","/Helpdesk.html","/Help.css","/script.js","/api/**","/css/**","/js/**").permitAll()
                .requestMatchers("/agent/**").hasRole("AGENT")
                .anyRequest().authenticated()
            )
            .formLogin(form->form
                .loginPage("/AgentLogin.html")
                .loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/Helpdesk.html", true)
                .permitAll()
            )
            .logout(logout->logout.permitAll());
        return http.build();
    }
    @Bean public UserDetailsService userDetailsService(){ return username -> { throw new RuntimeException("No userDetailsService"); }; }
    @Bean public BCryptPasswordEncoder passwordEncoder(){ return new BCryptPasswordEncoder(); }
    @Bean public DaoAuthenticationProvider authenticationProvider(UserDetailsService uds, BCryptPasswordEncoder encoder){ DaoAuthenticationProvider p=new DaoAuthenticationProvider(); p.setUserDetailsService(uds); p.setPasswordEncoder(encoder); return p; }
}
