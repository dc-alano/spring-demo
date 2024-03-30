package com.dcalano.demo.controller.action;

public interface ControllerActionGet<D, T> {

	D get(T id);
}
