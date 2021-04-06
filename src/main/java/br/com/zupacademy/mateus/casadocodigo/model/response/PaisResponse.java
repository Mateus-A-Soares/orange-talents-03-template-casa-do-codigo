package br.com.zupacademy.mateus.casadocodigo.model.response;

import br.com.zupacademy.mateus.casadocodigo.model.Pais;

/**
 * 
 * Classe modelo que encapsula os dados a serem enviados sobre pais pela API
 * 
 * @author Mateus Soares
 */
public class PaisResponse {

	private Long id;

	private String nome;

	/**
	 * Instância o objeto e popula com os dados encapsulados na pais recebido.
	 * 
	 * @param pais pais encapsulando os dados do registro.
	 */
	public PaisResponse(Pais pais) {
		this.id = pais.getId();
		this.nome = pais.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
}
