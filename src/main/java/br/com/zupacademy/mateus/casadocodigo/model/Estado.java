package br.com.zupacademy.mateus.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;

/**
 * 
 * Classe modelo da entidade Estado.
 * 
 * @author Mateus Soares
 */
@Entity
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Valid
	private EstadoParameters estadoParameters;
	
	/**
	 * Instância um Estado, populado com os dados representativos de um registro.
	 * 
	 * @param estadoId objeto representativo dos parâmetros da entidade Est.
	 */
	public Estado(Long id, EstadoParameters estadoId) {
		this.id = id;
		this.estadoParameters = estadoId;
	}

	/**
	 * Instância um Estado, populado com os dados representativos de um registro.
	 * 
	 * @param estadoId objeto representativo da chave primária composta nome - país.
	 */
	public Estado(EstadoParameters estadoParameters) {
		this.estadoParameters = estadoParameters;
	}

	public EstadoParameters getEstadoParameters() {
		return estadoParameters;
	}
	
	public Long getId() {
		return id;
	}
}