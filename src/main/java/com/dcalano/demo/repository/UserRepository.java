package com.dcalano.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcalano.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
