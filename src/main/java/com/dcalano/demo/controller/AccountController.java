package com.dcalano.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcalano.demo.dto.AccountDto;
import com.dcalano.demo.entity.Account;
import com.dcalano.demo.mapper.AccountMapper;
import com.dcalano.demo.service.AccountService;

@RestController
@RequestMapping("api/accounts")
public class AccountController extends BaseController<Account, AccountDto, Long> {

	protected AccountController(AccountService service, AccountMapper mapper) {
		super(service, mapper);
	}

}
