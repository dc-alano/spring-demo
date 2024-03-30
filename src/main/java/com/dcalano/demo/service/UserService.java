package com.dcalano.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcalano.demo.entity.User;
import com.dcalano.demo.repository.UserRepository;

@Service
@Transactional
public class UserService extends BaseService<User, Long> {

	public UserService(UserRepository repository) {
		super(repository);
	}

}
