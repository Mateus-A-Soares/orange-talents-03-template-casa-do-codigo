package br.com.zupacademy.mateus.casadocodigo.config.validation.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Payload;

/**
 *  Anotação utilizada nas classes que representam entidades, nos parâmetros que representam chaves estrangeiras
 *  em que deve ocorrer validação de existência na base de dados.
 *  
 * @author Mateus Soares
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsOne {
	
	String fieldTargetName();
	Class<?> entityTargetClass();
    String message() default "Registro não encontrado";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}