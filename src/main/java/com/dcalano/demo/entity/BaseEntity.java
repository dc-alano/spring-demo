package com.dcalano.demo.entity;

public interface BaseEntity<T> {

	T getId();

	void setId(T id);

}
