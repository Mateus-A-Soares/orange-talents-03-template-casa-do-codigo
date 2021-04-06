package br.com.zupacademy.mateus.casadocodigo.model.request;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.mateus.casadocodigo.config.validation.constraints.Unique;
import br.com.zupacademy.mateus.casadocodigo.model.Estado;
import br.com.zupacademy.mateus.casadocodigo.model.Pais;

/**
 * 
 * Classe modelo que representa os dados nas requests de cadastro de estadoes
 * 
 * @author Mateus Soares
 */
public class EstadoRequest {

	@NotNull @NotBlank @Unique(fieldName = "nome", entityClass = Estado.class, message = "Nome deve ser único")
	private String nome;
	
	@NotNull
	private Long paisId;

	@Deprecated
	public EstadoRequest() {
	}
	
	/**
	 * Construtor que instância um objeto EstadoRequest com os dados representativos da entidade estado.
	 * 
	 * @param nome nome do estado, único, não nulo ou vazio;
	 */
	public EstadoRequest(@NotNull @NotBlank String nome, Long paisId) {
		this.nome = nome;
		this.paisId = paisId;
	}
	
	public String getNome() {
		return nome;
	}

	/**
	 * Transforma o objeto EstadoRequest em um objeto Estado.
	 * 
	 * @return objeto Estado populado com os dados desse objeto.
	 */
	public Estado toModel(EntityManager manager) {
		Pais pais = manager.find(Pais.class, paisId);
		return new Estado(nome, pais);
	}
}
