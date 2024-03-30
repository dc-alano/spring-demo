package com.dcalano.demo.controller.action;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ControllerActionList<D> {

	Page<D> list(Pageable pageable);
}
