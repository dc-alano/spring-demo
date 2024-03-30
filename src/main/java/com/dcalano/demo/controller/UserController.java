package com.dcalano.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcalano.demo.dto.UserDto;
import com.dcalano.demo.entity.User;
import com.dcalano.demo.mapper.UserMapper;
import com.dcalano.demo.service.UserService;

@RestController
@RequestMapping("api/users")
public class UserController extends BaseController<User, UserDto, Long> {

	protected UserController(UserService service, UserMapper mapper) {
		super(service, mapper);
	}

}
