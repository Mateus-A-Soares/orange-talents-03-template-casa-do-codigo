package br.com.zupacademy.mateus.casadocodigo.config.validation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zupacademy.mateus.casadocodigo.config.validation.constraints.ExistsOnePaisOnEstadoParameters;
import br.com.zupacademy.mateus.casadocodigo.model.request.EstadoParametersRequest;

/**
 * Implementação do validator que executa a validação de existência do país, passado pelo parâmetro EstadoParameters na classe EstadoRequest.
 * 
 * @author Mateus Soares
 */
public class ExistsOnePaisOnEstadoParametersValidator implements ConstraintValidator<ExistsOnePaisOnEstadoParameters, EstadoParametersRequest> {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean isValid(EstadoParametersRequest estadoParametersRequest, ConstraintValidatorContext context) {
		Query query = manager.createQuery("SELECT 1 FROM Pais p WHERE p.id = :id");
		query.setParameter("id", estadoParametersRequest.getPaisId());
		return !query.getResultList().isEmpty();
	}
	
	@Override
	public void initialize(ExistsOnePaisOnEstadoParameters annotation) {
	}
}
