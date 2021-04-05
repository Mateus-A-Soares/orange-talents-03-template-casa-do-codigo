package br.com.zupacademy.mateus.casadocodigo.model;

import java.time.LocalDate;
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
	
	private String sumario;
	
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
	@NotNull
	private LocalDate dataLancamento;
	
	@NotNull
	@ManyToOne
	private Categoria categoria;
	
	@NotNull
	@ManyToOne
	private Autor autor;

	/**
	 * Construtor que instância um objeto Livro com os dados representativos do registro de um livro.
	 * 
     * @param id id do livro, não nulo;
	 * @param titulo titulo do livro, não nulo ou vazio e único;
	 * @param resumo titulo do livro, não nulo ou vazio e único;
	 * @param sumario sumario do livro;
	 * @param preco preço do livro, no mínimo 20.0;
	 * @param numeroPaginas numero de paginas do livro, no mínimo 100;
	 * @param isbn código identificador do livro, não nulo ou vazio mas de formato livre;
	 * @param dataLancamento data de lançamento do livro, não nula e necessariamente no futuro; 
	 * @param categoriaId id da categoria do livro, não pode estar vazio e deve ser um registro existente;
	 * @param autorId id do autor do livro, não pode estar vazio e deve ser um registro existente;
	 */
	public Livro(@NotNull Long id, @NotBlank String titulo, @NotBlank String resumo, String sumario, @Min(20) Double preco,
			@Min(100) Integer numeroPaginas, @NotBlank String isbn, @Future @NotNull LocalDate dataLancamento,
			@NotNull Categoria categoria, @NotNull Autor autor) {
		this.id = id;
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataLancamento = dataLancamento;
		this.categoria = categoria;
		this.autor = autor;
	}

	/**
	 * Construtor que instância um objeto Livro com os dados representativos do registro de um livro.
	 * 
	 * @param titulo titulo do livro, não nulo ou vazio e único;
	 * @param resumo titulo do livro, não nulo ou vazio e único;
	 * @param sumario sumario do livro;
	 * @param preco preço do livro, no mínimo 20.0;
	 * @param numeroPaginas numero de paginas do livro, no mínimo 100;
	 * @param isbn código identificador do livro, não nulo ou vazio mas de formato livre;
	 * @param dataLancamento data de lançamento do livro, não nula e necessariamente no futuro; 
	 * @param categoriaId id da categoria do livro, não pode estar vazio e deve ser um registro existente;
	 * @param autorId id do autor do livro, não pode estar vazio e deve ser um registro existente;
	 */
	public Livro(@NotBlank String titulo, @NotBlank String resumo, String sumario, @Min(20) Double preco,
			@Min(100) Integer numeroPaginas, @NotBlank String isbn, @Future LocalDate dataLancamento,
			@NotNull Categoria categoria, @NotNull Autor autor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataLancamento = dataLancamento;
		this.categoria = categoria;
		this.autor = autor;
	}

	@Deprecated
	public Livro() {}

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

	public Categoria getCategoria() {
		return categoria;
	}

	public Autor getAutor() {
		return autor;
	}
}
