package com.dcalano.demo;

public enum Role {
	ADMIN, USER;

	public String getRoleName() {
		return this.name().toLowerCase();
	}
}
