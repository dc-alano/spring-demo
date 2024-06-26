package com.dcalano.demo.service.action;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceActionList<E> {

	Page<E> list(Pageable pageable);
}
