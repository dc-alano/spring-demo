package com.dcalano.demo.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDto {

	private Long id;

	@NotBlank
	private String firstName;

	private String lastName;

	@Valid
	@NotNull
	private AccountDto account;
}
