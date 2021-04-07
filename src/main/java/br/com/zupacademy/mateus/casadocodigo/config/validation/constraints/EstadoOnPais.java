package br.com.zupacademy.mateus.casadocodigo.config.validation.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.zupacademy.mateus.casadocodigo.config.validation.EstadoOnPaisValidator;

/**
 *  Anotação utilizada na classe ClienteRequest para validações do relacionamento Estado - Pais do cliente.
 * 
 * @author Mateus Soares
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EstadoOnPaisValidator.class)
public @interface EstadoOnPais {
	 
	String message() default "Problema no link entre estado e país";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
