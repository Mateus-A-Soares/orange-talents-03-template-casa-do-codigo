package br.com.zupacademy.mateus.casadocodigo.model.request;

import java.time.LocalDateTime;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zupacademy.mateus.casadocodigo.config.validation.constraints.Unique;
import br.com.zupacademy.mateus.casadocodigo.model.Autor;

/**
 * 
 * Classe modelo que representa os dados nas requests de cadastro de autores
 * 
 * @author Mateus Soares
 */
public class AutorRequest {
	
	@NotBlank
	private String nome;
	@NotBlank @Email @Unique(fieldName = "email", entityClass = Autor.class, message = "Email deve ser único")
	private String email;
	@NotBlank @Size(max = 400)
	private String descricao;

	private LocalDateTime instanteCadastro;
	
	/**
	 * Construtor que instância um objeto AutorRequest com os dados representativos da entidade autor.
	 * 
	 * @param nome nome do autor, não nulo ou vazio;
	 * @param email email do autor, único, não nulo ou vazio e formatado como endereço de email;
	 * @param descricao descrição do autor, não nulo ou vazio e com tamanho máximo de 400 caracteres.
	 */
	public AutorRequest(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		instanteCadastro = LocalDateTime.now();
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

	public LocalDateTime getInstanteCadastro() {
		return instanteCadastro;
	}

	/**
	 * Transforma o objeto AutorRequest em um objeto Autor.
	 * 
	 * @return objeto Autor populado com os dados desse objeto.
	 */
	public Autor toModel() {
		return new Autor(instanteCadastro, nome, email, descricao);
	}
}
