package com.dcalano.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.dcalano.demo.dto.AccountDto;
import com.dcalano.demo.entity.Account;

@Mapper(componentModel = "spring")
public interface AccountMapper extends BaseMapper<Account, AccountDto> {

	@Override
	@Mapping(target = "user", ignore = true)
	Account toEntity(AccountDto dto);

	@Override
	@Mapping(target = "user", ignore = true)
	Account updateFromDto(@MappingTarget Account user, AccountDto userDto);

}
