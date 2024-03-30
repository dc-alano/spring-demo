package com.dcalano.demo.mapper;

import org.mapstruct.MappingTarget;

public interface BaseMapper<E, D> {

	D toDto(E entity);

	E toEntity(D dto);

	E updateFromDto(@MappingTarget E entity, D dto);

}
