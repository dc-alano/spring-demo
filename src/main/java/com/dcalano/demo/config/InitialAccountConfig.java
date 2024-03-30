package com.dcalano.demo.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.dcalano.demo.Role;
import com.dcalano.demo.entity.Account;
import com.dcalano.demo.entity.User;
import com.dcalano.demo.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Log
@Configuration
@AllArgsConstructor
public class InitialAccountConfig implements InitializingBean {

	private final PasswordEncoder passwordEncoder;

	private final UserRepository userRepository;

	@Override
	public void afterPropertiesSet() throws Exception {
		if (userRepository.count() > 0) {
			return;
		}

		String password = passwordEncoder.encode("password");
		String username = "admin";
		User user = User.builder() //
				.firstName("Admin")//
				.account(Account.builder() //
						.username(username) //
						.password(password) //
						.role(Role.ADMIN) //
						.enabled(true) //
						.build())
				.build();
		userRepository.save(user);
		log.info(String.format("Default user created [username=%s; password=%s]", username, password));
	}

}
