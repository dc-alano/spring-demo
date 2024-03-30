package com.dcalano.demo.controller.action;

import jakarta.validation.Valid;

public interface ControllerActionUpdate<D, T> {

	D update(T id, @Valid D dto);
}
