package br.com.zupacademy.mateus.casadocodigo.model.request;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import br.com.zupacademy.mateus.casadocodigo.config.validation.constraints.ExistsOnePaisOnEstadoId;
import br.com.zupacademy.mateus.casadocodigo.config.validation.constraints.UniqueEstadoId;
import br.com.zupacademy.mateus.casadocodigo.model.Estado;
import br.com.zupacademy.mateus.casadocodigo.model.EstadoId;
import br.com.zupacademy.mateus.casadocodigo.model.Pais;

/**
 * 
 * Classe modelo que representa os dados nas requests de cadastro de estados
 * 
 * @author Mateus Soares
 */
public class EstadoRequest {
	
	@UniqueEstadoId
	@ExistsOnePaisOnEstadoId
	@Valid
	private EstadoIdRequest estado;

	@Deprecated
	public EstadoRequest() {
	}
	
	/**
	 * Construtor que instância um objeto EstadoRequest com os dados representativos da chave composta nome - paisId.
	 * 
	 * @param estado objeto representativo da chave composta.
	 */
	public EstadoRequest(EstadoIdRequest estado) {
		this.estado = estado;
	}
	
	public EstadoIdRequest getEstado() {
		return estado;
	}

	/**
	 * Transforma o objeto EstadoRequest em um objeto Estado.
	 * 
	 * @return objeto Estado populado com os dados desse objeto.
	 */
	public Estado toModel(EntityManager manager) {
		Pais pais = manager.find(Pais.class, estado.getPaisId());
		return new Estado(new EstadoId(estado.getNome(), pais));
	}
}

