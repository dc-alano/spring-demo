package com.dcalano.demo.mapper;

import org.mapstruct.Mapper;

import com.dcalano.demo.dto.UserDto;
import com.dcalano.demo.entity.User;

@Mapper(componentModel = "spring", uses = AccountMapper.class)
public interface UserMapper extends BaseMapper<User, UserDto> {

}
