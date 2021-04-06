package br.com.zupacademy.mateus.casadocodigo.model.request;

import javax.validation.constraints.NotBlank;

/**
 * Classe representativa da chave composta para entidade Estado enviada em uma requisição.
 * 
 * @author Mateus Soares
 */
public class EstadoIdRequest {
	
	private Long paisId;
	@NotBlank
	private String nome;

	/**
	 * Instância um EstadoIdRequest com os parâmetros passados.
	 * 
	 * @param paisId id do país que o estado pertence;
	 * @param nome nome do estado a ser cadastrado.
	 */
	public EstadoIdRequest(Long paisId, @NotBlank String nome) {
		this.paisId = paisId;
		this.nome = nome;
	}
	
	@Deprecated
	public EstadoIdRequest() {
	}

	public Long getPaisId() {
		return paisId;
	}

	public String getNome() {
		return nome;
	}
}
