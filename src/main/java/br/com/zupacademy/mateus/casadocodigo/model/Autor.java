package br.com.zupacademy.mateus.casadocodigo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

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
	@NotBlank @Email
	private String email;
	
	@Column(nullable = false, length = 400)
	@NotBlank @Size(max = 400)
	private String descricao;
	
	public Autor(Long id, LocalDateTime instanteCadastro, String nome, String email, String descricao) {
		this.id = id;
		this.instanteCadastro = instanteCadastro;
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor(LocalDateTime instanteCadastro, String nome, String email, String descricao) {
		this.instanteCadastro = instanteCadastro;
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
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
