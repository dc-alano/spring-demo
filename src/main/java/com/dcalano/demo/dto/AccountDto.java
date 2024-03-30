package com.dcalano.demo.dto;

import com.dcalano.demo.entity.Account;
import com.dcalano.demo.enums.Role;
import com.dcalano.demo.validator.UniqueValue;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@UniqueValue(entityClass = Account.class, fields = { "username" })
public class AccountDto implements BaseDto {

	private Long id;

	@NotBlank
	private String username;

	@NotBlank
	private String password;

	@NotNull
	private Role role;

	private boolean enabled = true;
}
