package br.com.zupacademy.mateus.casadocodigo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

/**
 * Classe representativa da chave primária composta (que compões os dois únicos atributos) da entidade Estado
 * 
 * @author Mateus Soares
 */
@Embeddable
public class EstadoId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	@Column(nullable = false)
	private String nome;
	
	@ManyToOne
	private Pais pais;
	
	@Deprecated
	public EstadoId() {}
	
	/**
	 * Instância uma chave primária composta para o registro da entidade Estado.
	 * 
	 * @param nome nome do estado a ser cadastrado;
	 * @param pais registro do país ao qual o estado pertence.
	 */
	public EstadoId(String nome, Pais pais) {
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
