package br.com.zupacademy.mateus.casadocodigo.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * Classe representativa da chave primária composta (que compões os dois únicos atributos) da entidade Estado
 * 
 * @author Mateus Soares
 */
@Embeddable
public class EstadoId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	@ManyToOne
	private Pais pais;
	
	@Deprecated
	public EstadoId() {}
	
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
