package br.com.zupacademy.mateus.casadocodigo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	
	/**
	 * Construtor que instância um objeto Categoria com os dados representativos do registro de uma categoria.
	 * 
	 * @param id id da categoria, não nulo
	 * @param nome nome da categoria, único, não nulo ou vazio;
	 */
	public Categoria(@NotNull Long id, @NotBlank String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	/**
	 * Construtor que instância um objeto Categoria com os dados representativos do registro de uma categoria.
	 * 
	 * @param nome nome da categoria, único, não nulo ou vazio;
	 */
	public Categoria(@NotBlank String nome) {
		this.nome = nome;
	}
	
	/**
	 * Construtor vazio utilizado pela implementação da JPA.
	 */
	@Deprecated
	public Categoria() {}
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
}
