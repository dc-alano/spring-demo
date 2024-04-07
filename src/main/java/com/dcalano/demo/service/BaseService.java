package com.dcalano.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dcalano.demo.entity.BaseEntity;

import jakarta.persistence.EntityNotFoundException;

public abstract class BaseService<E extends BaseEntity<T>, T> implements CrudService<E, T> {

	protected final JpaRepository<E, T> repository;

	protected BaseService(JpaRepository<E, T> repository) {
		this.repository = repository;
	}

	@Override
	public E create(E entity) {
		return repository.save(entity);
	}

	@Override
	public void delete(T id) {
		repository.deleteById(id);
	}

	@Override
	public E get(T id) {
		return repository.findById(id) //
				.orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public Page<E> list(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public E update(T id, E entity) {
		return repository.findById(id) //
				.map(x -> entity) //
				.map(repository::save) //
				.orElseThrow(EntityNotFoundException::new);
	}

}
