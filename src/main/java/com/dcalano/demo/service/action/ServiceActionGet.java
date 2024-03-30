package com.dcalano.demo.service.action;

public interface ServiceActionGet<E, T> {

	E get(T id);
}
