package com.dcalano.demo.service.action;

public interface ServiceActionUpdate<E, T> {

	E update(T id, E user);
}
