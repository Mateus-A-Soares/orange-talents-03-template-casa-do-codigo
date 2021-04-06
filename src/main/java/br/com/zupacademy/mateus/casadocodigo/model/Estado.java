package br.com.zupacademy.mateus.casadocodigo.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * 
 * Classe modelo da entidade Estado.
 * 
 * @author Mateus Soares
 */
@Entity
public class Estado {
	
	@EmbeddedId
	private EstadoId estadoId;

	public Estado(EstadoId estadoId) {
		this.estadoId = estadoId;
	}

	public EstadoId getEstadoId() {
		return estadoId;
	}
}