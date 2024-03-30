package com.dcalano.demo.enums;

public enum Role {
	ADMIN, USER;

	public String getRoleName() {
		return this.name().toLowerCase();
	}
}
