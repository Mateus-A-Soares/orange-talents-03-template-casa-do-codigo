package br.com.zupacademy.mateus.casadocodigo.model.response;

import br.com.zupacademy.mateus.casadocodigo.model.Cliente;
import br.com.zupacademy.mateus.casadocodigo.model.Estado;
import br.com.zupacademy.mateus.casadocodigo.model.Pais;

/**
 * 
 * Classe modelo que encapsula os dados a serem enviados sobre clientes pela API
 * 
 * @author Mateus Soares
 */
public class ClienteResponse {

	private Long id;

    private String email;

    private String nome;

    private String sobrenome;

    private String documento;

    private String telefone;

    private String cep;

    private String endereco;

    private String complemento;

    private String cidade;

    private Pais pais;
    
    private Estado estado;

	/**
	 * Instância o objeto e popula com os dados encapsulados no Cliente recebido.
	 * 
	 * @param cliente objeto cliente encapsulando os dados do registro
	 */
	public ClienteResponse(Cliente cliente) {
		this.id = cliente.getId();
		this.email = cliente.getEmail();
		this.nome = cliente.getNome();
		this.sobrenome = cliente.getSobrenome();
		this.documento = cliente.getDocumento();
		this.telefone = cliente.getTelefone();
		this.cep = cliente.getCep();
		this.endereco = cliente.getEndereco();
		this.complemento = cliente.getComplemento();
		this.cidade = cliente.getCidade();
		this.pais = cliente.getPais();
		this.estado = cliente.getEstado();
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
