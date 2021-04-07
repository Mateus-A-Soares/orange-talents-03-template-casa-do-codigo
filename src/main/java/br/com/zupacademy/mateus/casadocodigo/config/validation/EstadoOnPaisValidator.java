package br.com.zupacademy.mateus.casadocodigo.config.validation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zupacademy.mateus.casadocodigo.config.validation.constraints.EstadoOnPais;
import br.com.zupacademy.mateus.casadocodigo.model.request.ClienteLocalizacaoResquest;

/**
 * Implementação do validator que executa as validações do relacionamento estado - pais na classe cliente, passado pelo parâmetro EstadoParameters na classe EstadoRequest.
 * 
 * @author Mateus Soares
 */
public class EstadoOnPaisValidator implements ConstraintValidator<EstadoOnPais, ClienteLocalizacaoResquest> {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public boolean isValid(ClienteLocalizacaoResquest localizacaoResquest, ConstraintValidatorContext context) {
		if(localizacaoResquest.getEstadoId() == null) {
			Query query = manager.createQuery("SELECT 1 FROM Estado e WHERE e.estadoParameters.pais.id = :paisId");
			query.setParameter("paisId", localizacaoResquest.getPaisId());
			return query.getResultList().isEmpty();
		}
		Query query = manager.createQuery("SELECT 1 FROM Estado e WHERE e.id = :estadoId AND e.estadoParameters.pais.id = :paisId");
		query.setParameter("estadoId", localizacaoResquest.getEstadoId());
		query.setParameter("paisId", localizacaoResquest.getPaisId());
		return !query.getResultList().isEmpty();
	}
	
	@Override
	public void initialize(EstadoOnPais annotation) {
	}
}
