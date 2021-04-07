package br.com.zupacademy.mateus.casadocodigo.config.validation.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

/**
 * Anotação que mescla as anotações CPF e CNPJ para validação de uma variável que possa se encaixar em um dos dois formatos.
 * 
 * @author Mateus Soares
 */
@ConstraintComposition(CompositionType.OR)
@CNPJ(message = "Documento mal formatado")
@CPF(message = "Documento mal formatado")
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
public @interface CpfCnpj {
	String message() default "Documento mal formatado";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
}
