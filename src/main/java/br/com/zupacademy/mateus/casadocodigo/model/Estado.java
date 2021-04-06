package br.com.zupacademy.mateus.casadocodigo.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.Valid;

/**
 * 
 * Classe modelo da entidade Estado.
 * 
 * @author Mateus Soares
 */
@Entity
public class Estado {
	
	@EmbeddedId
	@Valid
	private EstadoId estadoId;

	/**
	 * Instância um Estado, populado com os dados representativos de um registro.
	 * 
	 * @param estadoId objeto representativo da chave primária composta nome - país.
	 */
	public Estado(EstadoId estadoId) {
		this.estadoId = estadoId;
	}

	public EstadoId getEstadoId() {
		return estadoId;
	}
}