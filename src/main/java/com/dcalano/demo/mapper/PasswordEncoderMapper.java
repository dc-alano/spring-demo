package com.dcalano.demo.mapper;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@Component
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PasswordEncoderMapper {

	private final PasswordEncoder passwordEncoder;

	@PasswordEncoderMapping
	public String encode(String value) {
		return passwordEncoder.encode(value);
	}
}
