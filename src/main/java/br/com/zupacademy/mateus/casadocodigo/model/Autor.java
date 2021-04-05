package br.com.zupacademy.mateus.casadocodigo.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * Classe modelo da entidade Autor.
 * 
 * @author Mateus Soares
 */
@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@NotNull
	private LocalDateTime instanteCadastro;

	@Column(nullable = false)
	@NotBlank
	private String nome;

	@Column(unique = true, nullable = false)
	@NotBlank
	@Email
	private String email;

	@Column(nullable = false, length = 400)
	@NotBlank
	@Size(max = 400)
	private String descricao;

	/**
	 * Construtor que instância um objeto Autor com os dados representativos do registro de um autor.
	 * 
	 * @param id id do autor, não nulo;
	 * @param instanteCadastro instânte que o autor foi cadastrado, não nulo;
	 * @param nome nome do autor, não nulo ou vazio;
	 * @param email email do autor, único, não nulo ou vazio e formatado como endereço de email;
	 * @param descricao descrição do autor, não nulo ou vazio e com tamanho máximo de 400 caracteres.
	 */
	public Autor(@NotNull Long id, @NotNull LocalDateTime instanteCadastro, @NotBlank String nome,
			@NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
		this.id = id;
		this.instanteCadastro = instanteCadastro;
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	/**
	 * Construtor que instância um objeto Autor com os dados representativos do registro de um autor.
	 * 
	 * @param instanteCadastro instânte que o autor foi cadastrado, não nulo;
	 * @param nome nome do autor, não nulo ou vazio;
	 * @param email email do autor, único, não nulo ou vazio e formatado como endereço de email;
	 * @param descricao descrição do autor, não nulo ou vazio e com tamanho máximo de 400 caracteres.
	 */
	public Autor(@NotNull LocalDateTime instanteCadastro, @NotBlank String nome,
			@NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
		this.instanteCadastro = instanteCadastro;
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	/**
	 * Construtor vazio utilizado pela implementação da JPA.
	 */
	@Deprecated
	public Autor() {
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getInstanteCadastro() {
		return instanteCadastro;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}
}
