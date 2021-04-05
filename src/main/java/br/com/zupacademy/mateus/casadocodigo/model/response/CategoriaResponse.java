package br.com.zupacademy.mateus.casadocodigo.model.response;

import br.com.zupacademy.mateus.casadocodigo.model.Categoria;

/**
 * 
 * Classe modelo que encapsula os dados a serem enviados sobre categorias pela API
 * 
 * @author Mateus Soares
 */
public class CategoriaResponse {

	private Long id;

	private String nome;

	/**
	 * Instância o objeto e popula com os dados encapsulados na categoria recebido.
	 * 
	 * @param categoria categoria encapsulando os dados do registro.
	 */
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
