package br.com.zupacademy.mateus.casadocodigo.config.validation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zupacademy.mateus.casadocodigo.config.validation.constraints.UniqueEstadoParameters;
import br.com.zupacademy.mateus.casadocodigo.model.request.EstadoParametersRequest;

/**
 * Implementação do validator que executa a validação de unicidade do par de parâmetros nome e paisId da entidade Estado.
 * 
 * @author Mateus Soares
 */
public class UniqueEstadoIdValidator implements ConstraintValidator<UniqueEstadoParameters, EstadoParametersRequest> {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean isValid(EstadoParametersRequest estadoId, ConstraintValidatorContext context) {
		Query query = manager.createQuery("SELECT 1 FROM Estado e WHERE e.estadoParameters.pais.id = :paisId AND e.estadoParameters.nome = :nome");
		query.setParameter("paisId", estadoId.getPaisId());
		query.setParameter("nome", estadoId.getNome());
		return query.getResultList().isEmpty();
	}
	
	@Override
	public void initialize(UniqueEstadoParameters annotation) {
	}
}
