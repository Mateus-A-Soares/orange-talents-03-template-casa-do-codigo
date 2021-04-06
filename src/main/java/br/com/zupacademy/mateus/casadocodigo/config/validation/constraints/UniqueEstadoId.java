package br.com.zupacademy.mateus.casadocodigo.config.validation.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.zupacademy.mateus.casadocodigo.config.validation.UniqueEstadoIdValidator;

/**
 *  Anotação utilizada na classe EstadoRequest, para validação de unicidade do campo EstadoId que
 * representa a chave primária composta nome - país.
 *  
 * @author Mateus Soares
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueEstadoIdValidator.class)
public @interface UniqueEstadoId {
	String message() default "Chave duplicada";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
