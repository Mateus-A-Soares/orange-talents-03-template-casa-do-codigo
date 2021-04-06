package br.com.zupacademy.mateus.casadocodigo.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.mateus.casadocodigo.config.validation.constraints.Unique;
import br.com.zupacademy.mateus.casadocodigo.model.Pais;

/**
 * 
 * Classe modelo que representa os dados nas requests de cadastro de paises
 * 
 * @author Mateus Soares
 */
public class PaisRequest {

	@NotNull @NotBlank @Unique(fieldName = "nome", entityClass = Pais.class, message = "Nome deve ser único")
	private String nome;

	@Deprecated
	public PaisRequest() {
	}
	
	/**
	 * Construtor que instância um objeto PaisRequest com os dados representativos da entidade pais.
	 * 
	 * @param nome nome do pais, único, não nulo ou vazio;
	 */
	public PaisRequest(@NotNull @NotBlank String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	/**
	 * Transforma o objeto PaisRequest em um objeto Pais.
	 * 
	 * @return objeto Pais populado com os dados desse objeto.
	 */
	public Pais toModel() {
		return new Pais(nome);
	}
}
