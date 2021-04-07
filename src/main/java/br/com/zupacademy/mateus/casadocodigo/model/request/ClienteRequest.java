package br.com.zupacademy.mateus.casadocodigo.model.request;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.mateus.casadocodigo.config.validation.constraints.CpfCnpj;
import br.com.zupacademy.mateus.casadocodigo.config.validation.constraints.ExistsOne;
import br.com.zupacademy.mateus.casadocodigo.config.validation.constraints.Unique;
import br.com.zupacademy.mateus.casadocodigo.model.Cliente;
import br.com.zupacademy.mateus.casadocodigo.model.Estado;
import br.com.zupacademy.mateus.casadocodigo.model.Pais;

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
    
	@NotBlank
    private String cep;
   
	@NotBlank
    private String endereco;
    
	@NotBlank
    private String complemento;
    
	@NotBlank
    private String cidade;
    
	@NotNull
	@ExistsOne(entityTargetClass = Pais.class, fieldTargetName = "id")
    private Long paisId;
    
    private Long estadoId;

	/**
	 * Construtor que instância um objeto ClienteRequest com os dados representativos da entidade cliente.
	 * 
	 * @param email email do cliente, não nulo e formatado como endereço de email;
	 * @param nome nome do cliente, não nulo;
	 * @param sobrenome sobrenome do cliente, não nulo;
	 * @param documento documento do cliente, único, não nulo e formatado como CPF ou CNPJ;
	 * @param telefone telefone do cliente, não nulo;
	 * @param cep cep do cliente, não nulo;
	 * @param endereco endereço do cliente, não nulo;
	 * @param complemento complemento do endereço do cliente, não nulo;
	 * @param cidade cidade em que o cliente está, não nulo;
	 * @param pais país onde o cliente está, não nulo;
	 * @param estado estado onde o cliente está, se tiver estados cadastrados para o país vigente não deve estar nulo.
	 */
	public ClienteRequest(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String telefone, @NotBlank String cep, @NotBlank String endereco,
			@NotBlank String complemento, @NotBlank String cidade, @NotNull Long paisId, Long estadoId) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.telefone = telefone;
		this.cep = cep;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.paisId = paisId;
		this.estadoId = estadoId;
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

	public String getCep() {
		return cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Long getPaisId() {
		return paisId;
	}

	public Long getEstadoId() {
		return estadoId;
	}

	public Cliente toModel(EntityManager manager) {
		Pais pais = manager.find(Pais.class, paisId);
		Estado estado = manager.find(Estado.class, estadoId);
		return new Cliente(email, nome, sobrenome, documento, telefone, cep,
				endereco, complemento, cidade, pais, estado);
	}
}
