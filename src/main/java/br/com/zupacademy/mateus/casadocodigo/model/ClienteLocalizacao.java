package br.com.zupacademy.mateus.casadocodigo.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Classe representativa dos parâmetros relacionadas a localização da entidade Cliente.
 * 
 * @author Mateus Soares
 */
@Embeddable
public class ClienteLocalizacao {

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
    
	@ManyToOne
    private Estado estado;
	
	@Deprecated
	public ClienteLocalizacao() {
	}
	
	/**
	 * Instância um objeto ClienteLocalizacao com os valores representativos da localização de um cliente.
	 * 
	 * @param cep cep do cliente, formato livre e obrigatório;
	 * @param endereco endereço do cliente, formato livre e obrigatório;
	 * @param complemento complemento do endereço do cliente, formato livre e obrigatório;
	 * @param cidade nome da cidade do cliente, formato livre e obrigatório;
	 * @param pais pais onde o cliente está, não pode estar vazio;
	 * @param estado estado onde o cliente está, se o país tiver estados não pode estar vazio.
	 */
	public ClienteLocalizacao(@NotBlank String cep, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Pais pais, Estado estado) {
		this.cep = cep;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.estado = estado;
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
