package br.com.zupacademy.mateus.casadocodigo.model.request;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import br.com.zupacademy.mateus.casadocodigo.config.validation.constraints.ExistsOnePaisOnEstadoParameters;
import br.com.zupacademy.mateus.casadocodigo.config.validation.constraints.UniqueEstadoParameters;
import br.com.zupacademy.mateus.casadocodigo.model.Estado;
import br.com.zupacademy.mateus.casadocodigo.model.EstadoParameters;
import br.com.zupacademy.mateus.casadocodigo.model.Pais;

/**
 * 
 * Classe modelo que representa os dados nas requests de cadastro de estados
 * 
 * @author Mateus Soares
 */
public class EstadoRequest {
	
	@UniqueEstadoParameters
	@ExistsOnePaisOnEstadoParameters
	@Valid
	private EstadoParametersRequest estado;

	@Deprecated
	public EstadoRequest() {
	}
	
	/**
	 * Construtor que instância um objeto EstadoRequest com os dados representativos da entidade Estado.
	 * 
	 * @param estado objeto representativo dos parâmetros da entidade Estado.
	 */
	public EstadoRequest(EstadoParametersRequest estado) {
		this.estado = estado;
	}
	
	public EstadoParametersRequest getEstado() {
		return estado;
	}

	/**
	 * Transforma o objeto EstadoRequest em um objeto Estado.
	 * 
	 * @return objeto Estado populado com os dados desse objeto.
	 */
	public Estado toModel(EntityManager manager) {
		Pais pais = manager.find(Pais.class, estado.getPaisId());
		return new Estado(new EstadoParameters(estado.getNome(), pais));
	}
}

