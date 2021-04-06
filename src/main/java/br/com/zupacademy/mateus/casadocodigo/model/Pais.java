package br.com.zupacademy.mateus.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 
 * Classe modelo da entidade Pais.
 * 
 * @author Mateus Soares
 */
@Entity
public class Pais {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;

	/**
	 * Construtor que instância um objeto Pais com os dados representativos do registro de um pais.
	 * 
	 * @param id id do pais, não nulo
	 * @param nome nome do pais, único, não nulo ou vazio;
	 */
	public Pais(@NotNull Long id, @NotBlank String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	/**
	 * Construtor que instância um objeto Pais com os dados representativos do registro de um pais.
	 * 
	 * @param nome nome da categoria, único, não nulo ou vazio;
	 */
	public Pais(@NotBlank String nome) {
		this.nome = nome;
	}
	
	@Deprecated
	public Pais() {
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
}