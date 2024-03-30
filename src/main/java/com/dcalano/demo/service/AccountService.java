package com.dcalano.demo.service;

import org.springframework.stereotype.Service;

import com.dcalano.demo.entity.Account;
import com.dcalano.demo.repository.AccountRepository;

@Service
public class AccountService extends BaseService<Account, Long> {

	public AccountService(AccountRepository repository) {
		super(repository);
	}

}
