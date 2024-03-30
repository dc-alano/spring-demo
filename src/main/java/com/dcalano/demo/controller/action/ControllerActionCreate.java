package com.dcalano.demo.controller.action;

import jakarta.validation.Valid;

public interface ControllerActionCreate<D> {

	D create(@Valid D dto);
}
