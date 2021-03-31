package br.com.zupacademy.mateus.casadocodigo.model.response;

import br.com.zupacademy.mateus.casadocodigo.model.Categoria;

/**
 * 
 * Classe modelo que representa o envio de dados sobre categorias pela API
 * 
 * @author Mateus Soares
 */
public class CategoriaResponse {

	private Long id;

	private String nome;

	public CategoriaResponse(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
}
