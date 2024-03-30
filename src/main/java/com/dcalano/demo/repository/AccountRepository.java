package com.dcalano.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcalano.demo.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
