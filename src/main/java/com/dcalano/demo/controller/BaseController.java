package com.dcalano.demo.controller;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dcalano.demo.mapper.BaseMapper;
import com.dcalano.demo.service.BaseService;

import jakarta.validation.Valid;

public abstract class BaseController<E, D, T> {

	protected final BaseService<E, T> service;

	protected final BaseMapper<E, D> mapper;

	protected BaseController(BaseService<E, T> service, BaseMapper<E, D> mapper) {
		this.service = service;
		this.mapper = mapper;
	}

	@PostMapping
	public D create(@Valid @RequestBody D dto) {
		return Optional.ofNullable(dto) //
				.map(mapper::toEntity) //
				.map(service::create) //
				.map(mapper::toDto) //
				.orElse(null);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable T id) {
		service.delete(id);
	}

	@GetMapping("/{id}")
	public D get(@PathVariable T id) {
		return Optional.ofNullable(service.get(id)) //
				.map(mapper::toDto) //
				.orElse(null);
	}

	@GetMapping
	public Page<D> list(Pageable pageable) {
		return service.list(pageable).map(mapper::toDto);
	}

	@PatchMapping("/{id}")
	public D update(@PathVariable T id, @Valid @RequestBody D dto) {
		return Optional.of(dto) //
				.map(mapper::toEntity) //
				.map(x -> service.update(id, x)) //
				.map(mapper::toDto) //
				.orElseThrow();
	}

}
