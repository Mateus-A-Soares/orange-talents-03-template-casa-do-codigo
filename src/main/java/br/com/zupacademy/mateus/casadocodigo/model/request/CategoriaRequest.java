package br.com.zupacademy.mateus.casadocodigo.model.request;

import javax.validation.constraints.NotBlank;
import br.com.zupacademy.mateus.casadocodigo.config.validation.constraints.Unique;
import br.com.zupacademy.mateus.casadocodigo.model.Categoria;

/**
 * 
 * Classe modelo que representa os dados nas requests de cadastro de categorias
 * 
 * @author Mateus Soares
 *
 */
public class CategoriaRequest {

	@NotBlank @Unique(fieldName = "nome", entityClass = Categoria.class, message = "Nome deve ser único")
	private String nome;
	
	public CategoriaRequest(String nome) {
		this.nome = nome;
	}

	public Categoria toModel() {
		return new Categoria(nome);
	}
}
