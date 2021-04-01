package br.com.zupacademy.mateus.casadocodigo.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 
 * Classe modelo da entidade Livro.
 * 
 * @author Mateus Soares
 */
@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(unique = true, nullable = false)
	private String titulo;
	
	@NotBlank
	@Column(nullable = false)
	private String resumo;
	
	@Min(20)
	@Column(nullable = false)
	private Double preco;
	
	@Min(100)
	@Column(nullable = false)
	private Integer numeroPaginas;
	
	@NotBlank
	@Column(unique = true, nullable = false)
	private String isbn;
	
	@Future
	private LocalDateTime dataLancamento;
	
	@NotNull
	@ManyToOne
	private Categoria categoria;
	
	@NotNull
	@ManyToOne
	private Autor autor;

	public Livro(Long id, @NotBlank String titulo, @NotBlank String resumo, @Min(20) Double preco,
			@Min(100) Integer numeroPaginas, @NotBlank String isbn, @Future LocalDateTime dataLancamento,
			@NotNull Categoria categoria, @NotNull Autor autor) {
		this.id = id;
		this.titulo = titulo;
		this.resumo = resumo;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataLancamento = dataLancamento;
		this.categoria = categoria;
		this.autor = autor;
	}

	public Livro(@NotBlank String titulo, @NotBlank String resumo, @Min(20) Double preco,
			@Min(100) Integer numeroPaginas, @NotBlank String isbn, @Future LocalDateTime dataLancamento,
			@NotNull Categoria categoria, @NotNull Autor autor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataLancamento = dataLancamento;
		this.categoria = categoria;
		this.autor = autor;
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
