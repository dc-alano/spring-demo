package com.dcalano.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDto implements BaseDto<Long> {

	private Long id;

	@NotBlank
	private String firstName;

	private String lastName;

	@Valid
	@Nullable
	@JsonInclude(JsonInclude.Include.NON_ABSENT)
	private AccountDto account;
}
