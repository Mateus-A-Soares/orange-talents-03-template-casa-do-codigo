package br.com.zupacademy.mateus.casadocodigo.config.validation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zupacademy.mateus.casadocodigo.config.validation.constraints.UniqueEstadoId;
import br.com.zupacademy.mateus.casadocodigo.model.request.EstadoIdRequest;

/**
 * Implementação do validator que executa a validação de unicidade da chave composta da entidade Estado.
 * 
 * @author Mateus Soares
 */
public class UniqueEstadoIdValidator implements ConstraintValidator<UniqueEstadoId, EstadoIdRequest> {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean isValid(EstadoIdRequest estadoId, ConstraintValidatorContext context) {
		Query query = manager.createQuery("SELECT 1 FROM Estado e WHERE e.estadoId.pais.id = :paisId AND e.estadoId.nome = :nome");
		query.setParameter("paisId", estadoId.getPaisId());
		query.setParameter("nome", estadoId.getNome());
		return query.getResultList().isEmpty();
	}
	
	@Override
	public void initialize(UniqueEstadoId annotation) {
	}
}
