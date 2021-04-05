package br.com.zupacademy.mateus.casadocodigo.model.request;

import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.mateus.casadocodigo.config.validation.constraints.ExistsOne;
import br.com.zupacademy.mateus.casadocodigo.config.validation.constraints.Unique;
import br.com.zupacademy.mateus.casadocodigo.model.Autor;
import br.com.zupacademy.mateus.casadocodigo.model.Categoria;
import br.com.zupacademy.mateus.casadocodigo.model.Livro;

/**
 * 
 * Classe modelo que representa os dados nas requests de cadastro de livros.
 * 
 * @author Mateus Soares
 */
public class LivroRequest {

	@NotBlank
	@Unique(entityClass = Livro.class, fieldName = "titulo")
	private String titulo;
	
	@NotBlank
	private String resumo;
	
	@Min(20)
	private Double preco;
	
	@Min(100)
	private Integer numeroPaginas;
	
	@NotBlank
	@Unique(entityClass = Livro.class, fieldName = "isbn")
	private String isbn;
	
	@Future @NotNull
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataLancamento;
	
	@NotNull
	@ExistsOne(entityTargetClass = Autor.class, fieldTargetName = "id")
	private Long autorId;
	
	@NotNull
	@ExistsOne(entityTargetClass = Categoria.class, fieldTargetName = "id")
	private Long categoriaId;

	public LivroRequest(@NotBlank String titulo, @NotBlank String resumo, @Min(20) Double preco,
			@Min(100) Integer numeroPaginas, @NotBlank String isbn,
			@NotNull Long autorId, Long categoriaId) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.categoriaId = categoriaId;
		this.autorId = autorId;
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

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	public Long getAutorId() {
		return autorId;
	}
	
	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	
	public Livro toModel(EntityManager entityManager) {
		Autor autor = entityManager.find(Autor.class, autorId);
		Categoria categoria = entityManager.find(Categoria.class, categoriaId);
		return new Livro(titulo, resumo, preco, numeroPaginas, isbn, dataLancamento, categoria, autor);
	}
}
