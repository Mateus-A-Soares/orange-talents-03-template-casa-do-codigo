package br.com.zupacademy.mateus.casadocodigo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Classe representativa dos parâmetros da entidade Estado
 * 
 * @author Mateus Soares
 */
@Embeddable
public class EstadoParameters implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	@Column(nullable = false)
	private String nome;
	
	@NotNull
	@ManyToOne(optional = false)
	private Pais pais;
	
	@Deprecated
	public EstadoParameters() {}
	
	/**
	 * Instância um objeto EstadoParameters com os valores representativos de um registro da entidade Estado.
	 * 
	 * @param nome nome do estado a ser cadastrado;
	 * @param pais registro do país ao qual o estado pertence.
	 */
	public EstadoParameters(String nome, Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Pais getPais() {
		return pais;
	}
}
