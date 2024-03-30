package com.dcalano.demo.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@java.lang.annotation.Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueValueValidator.class)
public @interface UniqueValue {

	Class<?> entityClass();

	String[] fields();

	Class<?>[] groups() default {};

	String idFieldName() default "id";

	String message() default "must be unique";

	Class<? extends Payload>[] payload() default {};

}
