package br.com.zupacademy.mateus.casadocodigo.model.response;

import java.time.LocalDateTime;

import br.com.zupacademy.mateus.casadocodigo.model.Autor;

/**
 * 
 * Classe modelo que encapsula os dados a serem enviados sobre autores pela API
 * 
 * @author Mateus Soares
 */
public class AutorResponse {

	private Long id;

	private LocalDateTime instanteCadastro;

	private String nome;

	private String email;

	private String descricao;

	/**
	 * Instância o objeto e popula com os dados encapsulados no autor recebido.
	 * 
	 * @param autor autor encapsulando os dados do registro.
	 */
	public AutorResponse(Autor autor) {
		this.id = autor.getId();
		this.instanteCadastro = autor.getInstanteCadastro();
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.descricao = autor.getDescricao();
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
