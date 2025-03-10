package com.example.car_dealership.config;

import com.example.car_dealership.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserService internalUserService;

    @Bean
    public UserDetailsService userDetailsService() {
        return internalUserService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(internalUserService);
        provider.setPasswordEncoder(encodePassword());
        return provider;
    }

    @Bean
    public PasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity httpSecurity,
            LoginSuccessHandler loginSuccessHandler
    ) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(httpForm -> {
                    httpForm.loginPage("/login").permitAll();
                    httpForm.successHandler(loginSuccessHandler);
                })
                .logout(logout -> logout.logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll())
                .exceptionHandling(exception -> exception.authenticationEntryPoint(
                        (request, response, authException) -> response.sendError(401, "Unauthorized: Please login first.")
                ))
                .authorizeHttpRequests(registry -> {
                    registry.requestMatchers(
                            "/register/customer",
                            "/register/dealership",
                            "/css/**",
                            "/js/**",
                            "/images/**",
                            "/swagger-ui/**",
                            "/v3/api-docs/**"
                    ).permitAll();
                    // Security scope for the role "dealership"
                    registry.requestMatchers(
                            "/dealership/dashboard",
                            "/dealership/dashboard/add-a-car",
                            "/dealership/dashboard/edit-a-car",
                            "/dealership/dashboard/cars"
                    ).hasAnyAuthority("dealership");
                    // Security scope for the role "customer"
                    registry.requestMatchers(
                            "/customer/dashboard"
                    ).hasAnyAuthority("customer");
                    registry.anyRequest().authenticated();
                })
                .build();
    }
}