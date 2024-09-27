package com.smart_city.Security;

import java.util.Arrays;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
	

	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();  // BCrypt password encoder
	    }
	 

	    // AuthenticationManager bean
	    @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
	        return authenticationConfiguration.getAuthenticationManager();
	    }

	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .cors()  // Enable CORS
	            .and()
	            .csrf().disable()  // Disable CSRF
	            .authorizeHttpRequests(authz -> authz
	            		.requestMatchers("/login", "/api/tourism/cities/**").permitAll()
	            		.requestMatchers("/api/auth/login").permitAll()
	            		 .requestMatchers("/api/auth/register").permitAll()
	                .requestMatchers("/api/tourism/feedback").permitAll() // Allow public access
	                .requestMatchers("/api/tourism/destinations/**").permitAll() 
	                .anyRequest().authenticated() // Require authentication for all other requests
	            )
	            .formLogin(form -> form
	                .loginPage("/login") // Custom login page
	                .permitAll()  // Allow access to the login page
	            )
	            .logout(logout -> logout.permitAll());  // Allow logout

	        return http.build();
	    }
	    // Define CORS configuration
	    @Bean
	    public CorsConfigurationSource corsConfigurationSource() {
	        CorsConfiguration configuration = new CorsConfiguration();
	        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));  // Add your frontend URL
	        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));  // Allowed methods
	        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));  // Allowed headers
	        configuration.setAllowCredentials(true);  // Allow credentials like cookies or authorization headers
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", configuration);  // Apply CORS configuration to all endpoints
	        return source;
	}
	    
	    
	    @Bean
	    public HttpFirewall allowSemicolonInUrl() {
	        StrictHttpFirewall firewall = new StrictHttpFirewall();
	        // Allow semicolons in URLs
	        firewall.setAllowSemicolon(true);
	        return firewall;
	    }
}