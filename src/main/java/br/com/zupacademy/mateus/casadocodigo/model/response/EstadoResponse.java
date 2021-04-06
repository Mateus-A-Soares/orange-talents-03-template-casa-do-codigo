package br.com.zupacademy.mateus.casadocodigo.model.response;

import br.com.zupacademy.mateus.casadocodigo.model.Estado;

/**
 * 
 * Classe modelo que encapsula os dados a serem enviados sobre estados pela API
 * 
 * @author Mateus Soares
 */
public class EstadoResponse {

	private Long id;

	private String nome;
	
	private PaisResponse pais;

	/**
	 * Instância o objeto e popula com os dados encapsulados na estado recebido.
	 * 
	 * @param estado estado encapsulando os dados do registro.
	 */
	public EstadoResponse(Estado estado) {
		this.id = estado.getId();
		this.nome = estado.getNome();
		this.pais = new PaisResponse(estado.getPais());
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public PaisResponse getPais() {
		return pais;
	}
}
