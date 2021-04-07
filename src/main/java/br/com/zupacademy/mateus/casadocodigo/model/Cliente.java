package br.com.zupacademy.mateus.casadocodigo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * 
 * Classe modelo da entidade Cliente.
 * 
 * @author Mateus Soares
 */
@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Email @NotBlank
	@Column(nullable = false)
    private String email;
    
	@NotBlank
	@Column(nullable = false)
    private String nome;
 
	@NotBlank
	@Column(nullable = false)
    private String sobrenome;
    
	@NotBlank
	@Column(nullable = false)
    private String documento;
    
	@NotBlank
	@Column(nullable = false)
    private String telefone;
    
	@Valid
	private ClienteLocalizacao clienteLocalizacao;

	/**
	 * Construtor que instância um objeto Cliente com os dados representativos do registro de um cliente.
	 * 
	 * @param id id do cliente;
	 * @param email email do cliente, não nulo e formatado como endereço de email;
	 * @param nome nome do cliente, não nulo;
	 * @param sobrenome sobrenome do cliente, não nulo;
	 * @param documento documento do cliente, único, não nulo e formatado como CPF ou CNPJ;
	 * @param telefone telefone do cliente, não nulo;
	 * @param clienteLocalizacao objeto representativo dos campos relacionado a localização do cliente.
	 */
	public Cliente(Long id, @Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String telefone, ClienteLocalizacao clienteLocalizacao) {
		this.id = id;
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.telefone = telefone;
		this.clienteLocalizacao = clienteLocalizacao;
	}

	/**
	 * Construtor que instância um objeto Cliente com os dados representativos do registro de um cliente.
	 * 
	 * @param email email do cliente, não nulo e formatado como endereço de email;
	 * @param nome nome do cliente, não nulo;
	 * @param sobrenome sobrenome do cliente, não nulo;
	 * @param documento documento do cliente, único, não nulo e formatado como CPF ou CNPJ;
	 * @param telefone telefone do cliente, não nulo;
	 * @param clienteLocalizacao objeto representativo dos campos relacionado a localização do cliente.
	 */
	public Cliente(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String telefone, ClienteLocalizacao clienteLocalizacao) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.telefone = telefone;
		this.clienteLocalizacao = clienteLocalizacao;
	}
	
	@Deprecated
	public Cliente() {
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getTelefone() {
		return telefone;
	}

	public ClienteLocalizacao getClienteLocalizacao() {
		return clienteLocalizacao;
	}
}
