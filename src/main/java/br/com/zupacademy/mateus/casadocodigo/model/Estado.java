package br.com.zupacademy.mateus.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 
 * Classe modelo da entidade Estado.
 * 
 * @author Mateus Soares
 */
@Entity
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@ManyToOne
	private Pais pais;

	/**
	 * Construtor que instância um objeto Estado com os dados representativos do registro de um estado.
	 * 
	 * @param id id do estado, não nulo
	 * @param nome nome do estado, único, não nulo ou vazio;
	 */
	public Estado(@NotNull Long id, @NotBlank String nome, @NotNull Pais pais) {
		this.id = id;
		this.nome = nome;
		this.pais = pais;
	}
	
	/**
	 * Construtor que instância um objeto Pais com os dados representativos do registro de um pais.
	 * 
	 * @param nome nome da categoria, único, não nulo ou vazio;
	 */
	public Estado(@NotBlank String nome, @NotNull Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public Pais getPais() {
		return pais;
	}
}