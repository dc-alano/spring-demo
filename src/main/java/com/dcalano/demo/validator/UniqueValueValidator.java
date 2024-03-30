package com.dcalano.demo.validator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

	@PersistenceContext
	private EntityManager entityManager;

	private Class<?> entityClass;

	private String idFieldName;

	private String[] targetFieldNames;

	private boolean executeQueryLanguage(Object object, String queryString) {
		Query query = entityManager.createQuery(queryString);
		try {
			Object id = getFieldValue(object, idFieldName);
			query.setParameter("id", id);
			for (String fieldName : targetFieldNames) {
				Object fieldValue = getFieldValue(object, fieldName);
				query.setParameter(fieldName, fieldValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		Long count = (Long) query.getSingleResult();
		return count > 0;
	}

	private String generateQueryLanguage(String entityName) {
		String fieldNameQuery = getFieldNameQuery();
		return new StringBuilder() //
				.append("SELECT COUNT(e) FROM ") //
				.append(entityName) //
				.append(" AS e ") //
				.append("WHERE ") //
				.append("(e.") //
				.append(idFieldName) //
				.append(" IS NULL AND ") //
				.append(fieldNameQuery) //
				.append(") ") //
				.append("OR ") //
				.append("(e.") //
				.append(idFieldName) //
				.append(" IS NOT NULL AND e.") //
				.append(idFieldName) //
				.append("<> :id AND ") //
				.append(fieldNameQuery) //
				.append(")") //
				.toString();
	}

	private String getEntityName(Class<Entity> entityAnnotationClass) {
		Entity entityAnnotation = entityClass.getAnnotation(entityAnnotationClass);
		return StringUtils.defaultIfBlank(entityAnnotation.name(), entityClass.getSimpleName());
	}

	private String getFieldNameQuery() {
		return Arrays.stream(targetFieldNames) //
				.map(x -> "e." + x + " = :" + x) //
				.collect(Collectors.joining(" AND "));
	}

	private Object getFieldValue(Object obj, String fieldName) throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		String methodName = "get" + StringUtils.capitalize(fieldName);
		Class<? extends Object> objClass = obj.getClass();
		Method getterMethod = objClass.getDeclaredMethod(methodName);
		return getterMethod.invoke(obj);
	}

	@Override
	public void initialize(UniqueValue constraintAnnotation) {
		entityClass = constraintAnnotation.entityClass();
		idFieldName = constraintAnnotation.idFieldName();
		targetFieldNames = constraintAnnotation.fields();
	}

	@Override
	public boolean isValid(Object object, ConstraintValidatorContext context) {
		return validateEntityAnnotation(object) //
				.map(this::getEntityName) //
				.map(this::generateQueryLanguage) //
				.map(queryString -> executeQueryLanguage(object, queryString)) //
				.orElseThrow();
	}

	private Optional<Class<Entity>> validateEntityAnnotation(Object object) {
		Class<Entity> entityAnnotationClass = Entity.class;
		if (!entityClass.isAnnotationPresent(entityAnnotationClass)) {
			String className = object.getClass().getCanonicalName();
			String annotationName = entityAnnotationClass.getCanonicalName();
			String message = String.format("Class [%s] Parameter [entityClass] does not have %s annotation", className,
					annotationName);
			throw new IllegalArgumentException(message);
		}
		return Optional.of(entityAnnotationClass);
	}

}
