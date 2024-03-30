package com.dcalano.demo.service.action;

public interface Update<E, T> {

	E update(T id, E user);
}
