package br.com.zupacademy.mateus.casadocodigo.model.response;

import java.time.LocalDateTime;

import br.com.zupacademy.mateus.casadocodigo.model.Autor;
import br.com.zupacademy.mateus.casadocodigo.model.Categoria;
import br.com.zupacademy.mateus.casadocodigo.model.Livro;

/**
 * 
 * Classe modelo que representa o envio de dados sobre livros pela API
 * 
 * @author Mateus Soares
 */
public class LivroResponse {
	
	private Long id;

	private String titulo;

	private String resumo;

	private Double preco;

	private Integer numeroPaginas;

	private String isbn;

	private LocalDateTime dataLancamento;

	private Categoria categoria;
	
	private Autor autor;

	public LivroResponse(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.preco = livro.getPreco();
		this.numeroPaginas = livro.getNumeroPaginas();
		this.isbn = livro.getIsbn();
		this.dataLancamento = livro.getDataLancamento();
		this.categoria = livro.getCategoria();
		this.autor = livro.getAutor();
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

	public Double getPreco() {
		return preco;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDateTime getDataLancamento() {
		return dataLancamento;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Autor getAutor() {
		return autor;
	}
}
