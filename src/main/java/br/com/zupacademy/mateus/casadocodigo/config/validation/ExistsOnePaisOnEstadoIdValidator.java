package br.com.zupacademy.mateus.casadocodigo.config.validation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zupacademy.mateus.casadocodigo.config.validation.constraints.ExistsOnePaisOnEstadoId;
import br.com.zupacademy.mateus.casadocodigo.model.request.EstadoIdRequest;

/**
 * Implementação do validator que executa a validação de existência do país, passado pelo parâmetro EstadoId na classe EstadoRequest.
 * 
 * @author Mateus Soares
 */
public class ExistsOnePaisOnEstadoIdValidator implements ConstraintValidator<ExistsOnePaisOnEstadoId, EstadoIdRequest> {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean isValid(EstadoIdRequest estadoIdRequest, ConstraintValidatorContext context) {
		Query query = manager.createQuery("SELECT 1 FROM Pais p WHERE p.id = :id");
		query.setParameter("id", estadoIdRequest.getPaisId());
		return !query.getResultList().isEmpty();
	}
	
	@Override
	public void initialize(ExistsOnePaisOnEstadoId annotation) {
	}
}
