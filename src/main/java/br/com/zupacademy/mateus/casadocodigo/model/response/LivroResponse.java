package br.com.zupacademy.mateus.casadocodigo.model.response;

import java.time.LocalDate;

import br.com.zupacademy.mateus.casadocodigo.model.Livro;

/**
 * 
 * Classe modelo que encapsula os dados a serem enviados sobre livros pela API
 * 
 * @author Mateus Soares
 */
public class LivroResponse {
	
	private Long id;

	private String titulo;

	private String resumo;
	
	private String sumario;

	private Double preco;

	private Integer numeroPaginas;

	private String isbn;

	private LocalDate dataLancamento;

	private CategoriaResponse categoria;
	
	private AutorResponse autor;

	/**
	 * Instância o objeto e popula com os dados encapsulados no livro recebido.
	 * 
	 * @param livro livro encapsulando os dados do registro.
	 */
	public LivroResponse(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numeroPaginas = livro.getNumeroPaginas();
		this.isbn = livro.getIsbn();
		this.dataLancamento = livro.getDataLancamento();
		this.categoria = new CategoriaResponse(livro.getCategoria());
		this.autor = new AutorResponse(livro.getAutor());
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}
	
	public String getSumario() {
		return sumario;
	}

	public Double getPreco() {
		return preco;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public CategoriaResponse getCategoria() {
		return categoria;
	}
	
	public AutorResponse getAutor() {
		return autor;
	}
}
