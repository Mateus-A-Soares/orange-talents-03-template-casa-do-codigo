package br.com.zupacademy.mateus.casadocodigo.config.validation.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.zupacademy.mateus.casadocodigo.config.validation.ExistsOnePaisOnEstadoIdValidator;

/**
 *  Anotação utilizada na classe EstadoRequest para verificar existência do país enviado pela requisição
 *  no parâmetro EstadoIdRequest.
 *  
 * @author Mateus Soares
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExistsOnePaisOnEstadoIdValidator.class)
public @interface ExistsOnePaisOnEstadoId {

    String message() default "País não encontrado";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}