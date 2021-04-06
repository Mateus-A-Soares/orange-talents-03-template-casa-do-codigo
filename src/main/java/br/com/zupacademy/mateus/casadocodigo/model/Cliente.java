package br.com.zupacademy.mateus.casadocodigo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    
	@NotBlank
	@Column(nullable = false)
    private String cep;
   
	@NotBlank
	@Column(nullable = false)
    private String endereco;
    
	@NotBlank
	@Column(nullable = false)
    private String complemento;
    
	@NotBlank
	@Column(nullable = false)
    private String cidade;
    
	@NotNull
	@ManyToOne(optional = false)
    private Pais pais;
    
	@NotBlank
	@ManyToOne
    private Estado estado;

	/**
	 * Construtor que instância um objeto Cliente com os dados representativos do registro de um cliente.
	 * 
	 * @param id id do cliente;
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
	public Cliente(Long id, @Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String telefone, @NotBlank String cep, @NotBlank String endereco,
			@NotBlank String complemento, @NotBlank String cidade, @NotNull Pais pais, @NotBlank Estado estado) {
		this.id = id;
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.telefone = telefone;
		this.cep = cep;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.estado = estado;
	}

	/**
	 * Construtor que instância um objeto Cliente com os dados representativos do registro de um cliente.
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
	public Cliente(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String telefone, @NotBlank String cep, @NotBlank String endereco,
			@NotBlank String complemento, @NotBlank String cidade, @NotNull Pais pais, @NotBlank Estado estado) {
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
		this.pais = pais;
		this.estado = estado;
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

	public Pais getPais() {
		return pais;
	}

	public Estado getEstado() {
		return estado;
	}
}
