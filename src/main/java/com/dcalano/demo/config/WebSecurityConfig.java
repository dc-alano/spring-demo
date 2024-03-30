package com.dcalano.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
class WebSecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http //
				.authorizeHttpRequests(requests -> requests //
						.anyRequest().permitAll() //
				) //
				.csrf(AbstractHttpConfigurer::disable) //
				.logout(Customizer.withDefaults())//
				.oauth2Login(Customizer.withDefaults());

		return http.build();
	}
}