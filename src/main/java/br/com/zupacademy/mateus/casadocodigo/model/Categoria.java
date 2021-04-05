package br.com.zupacademy.mateus.casadocodigo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 * 
 * Classe modelo da entidade Categoria.
 * 
 * @author Mateus Soares
 */
@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	@NotBlank
	private String nome;
	
	public Categoria(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public Categoria(String nome) {
		this.nome = nome;
	}
	
	public Categoria() {}
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
}
