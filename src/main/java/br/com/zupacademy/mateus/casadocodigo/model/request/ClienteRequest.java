package br.com.zupacademy.mateus.casadocodigo.model.request;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.zupacademy.mateus.casadocodigo.config.validation.constraints.CpfCnpj;
import br.com.zupacademy.mateus.casadocodigo.config.validation.constraints.Unique;
import br.com.zupacademy.mateus.casadocodigo.model.Cliente;

/**
 * 
 * Classe modelo que representa os dados nas requests de cadastro de clientes
 * 
 * @author Mateus Soares
 */
public class ClienteRequest {
	
	@Email @NotBlank
	@Unique(entityClass = Cliente.class, fieldName = "email")
    private String email;
    
	@NotBlank
    private String nome;
 
	@NotBlank
    private String sobrenome;
    
	@NotBlank
	@Unique(entityClass = Cliente.class, fieldName = "documento")
	@CpfCnpj
    private String documento;
    
	@NotBlank
    private String telefone;
	
	@Valid
	private ClienteLocalizacaoResquest localizacao;

	/**
	 * Construtor que instância um objeto ClienteRequest com os dados representativos da entidade cliente.
	 * 
	 * @param email email do cliente, não nulo e formatado como endereço de email;
	 * @param nome nome do cliente, não nulo;
	 * @param sobrenome sobrenome do cliente, não nulo;
	 * @param documento documento do cliente, único, não nulo e formatado como CPF ou CNPJ;
	 * @param telefone telefone do cliente, não nulo;
	 * @param localizacao objeto representativo dos campos relacionado a localização do cliente.
	 */
	public ClienteRequest(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String telefone, ClienteLocalizacaoResquest localizacao) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.telefone = telefone;
		this.localizacao = localizacao;
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

	public ClienteLocalizacaoResquest getLocalizacao() {
		return localizacao;
	}

	public Cliente toModel(EntityManager manager) {
		
		return new Cliente(email, nome, sobrenome, documento, telefone, localizacao.toModel(manager));
	}
}
