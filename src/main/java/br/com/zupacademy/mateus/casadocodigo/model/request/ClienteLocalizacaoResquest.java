package br.com.zupacademy.mateus.casadocodigo.model.request;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.mateus.casadocodigo.config.validation.constraints.ExistsOne;
import br.com.zupacademy.mateus.casadocodigo.model.ClienteLocalizacao;
import br.com.zupacademy.mateus.casadocodigo.model.Estado;
import br.com.zupacademy.mateus.casadocodigo.model.Pais;

/**
 * Classe representativa dos parâmetros relacionadas a localização da entidade Cliente enviados nas requests.
 * 
 * @author Mateus Soares
 */
@Embeddable
public class ClienteLocalizacaoResquest {

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
	
	@Deprecated
	public ClienteLocalizacaoResquest() {
	}
	
	/**
	 * Instância um objeto ClienteLocalizacaoRequest com os parâmetros passados.
	 * 
	 * @param cep cep do cliente, formato livre e obrigatório;
	 * @param endereco endereço do cliente, formato livre e obrigatório;
	 * @param complemento complemento do endereço do cliente, formato livre e obrigatório;
	 * @param cidade nome da cidade do cliente, formato livre e obrigatório;
	 * @param pais pais onde o cliente está, não pode estar vazio;
	 * @param estado estado onde o cliente está, se o país tiver estados não pode estar vazio.
	 */
	public ClienteLocalizacaoResquest(@NotBlank String cep, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Long paisId, Long estadoId) {
		this.cep = cep;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.paisId = paisId;
		this.estadoId = estadoId;
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

	public Long getEstadoId() {
		return estadoId;
	}

	public Long getPaisId() {
		return paisId;
	}
	
	public ClienteLocalizacao toModel(EntityManager manager) {
		Pais pais = manager.find(Pais.class, paisId);
		Estado estado = manager.find(Estado.class, estadoId);
		return new ClienteLocalizacao(cep, endereco, complemento, cidade, pais, estado);
	}
}
