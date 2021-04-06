package br.com.zupacademy.mateus.casadocodigo.model.response;

import br.com.zupacademy.mateus.casadocodigo.model.Estado;
import br.com.zupacademy.mateus.casadocodigo.model.EstadoId;

/**
 * 
 * Classe modelo que encapsula os dados a serem enviados sobre estados pela API
 * 
 * @author Mateus Soares
 */
public class EstadoResponse {

	private String nome;
	
	private PaisResponse pais;

	/**
	 * Instância o objeto e popula com os dados encapsulados na estado recebido.
	 * 
	 * @param estado estado encapsulando os dados do registro.
	 */
	public EstadoResponse(Estado estado) {
		EstadoId estadoId = estado.getEstadoId();
		this.nome = estadoId.getNome();
		this.pais = new PaisResponse(estadoId.getPais());
	}

	public String getNome() {
		return nome;
	}
	
	public PaisResponse getPais() {
		return pais;
	}
}
