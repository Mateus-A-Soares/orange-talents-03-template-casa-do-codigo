package br.com.zupacademy.mateus.casadocodigo.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.mateus.casadocodigo.config.validation.constraints.Unique;
import br.com.zupacademy.mateus.casadocodigo.model.Categoria;

/**
 * 
 * Classe modelo que representa os dados nas requests de cadastro de categorias
 * 
 * @author Mateus Soares
 */
public class CategoriaRequest {

	@NotNull @NotBlank @Unique(fieldName = "nome", entityClass = Categoria.class, message = "Nome deve ser único")
	private String nome;

	@Deprecated
	public CategoriaRequest() {
	}
	
	/**
	 * Construtor que instância um objeto CategoriaRequest com os dados representativos da entidade categoria.
	 * 
	 * @param nome nome da categoria, único, não nulo ou vazio;
	 */
	public CategoriaRequest(@NotNull @NotBlank String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	/**
	 * Transforma o objeto CategoriaRequest em um objeto Categoria.
	 * 
	 * @return objeto Categoria populado com os dados desse objeto.
	 */
	public Categoria toModel() {
		return new Categoria(nome);
	}
}
