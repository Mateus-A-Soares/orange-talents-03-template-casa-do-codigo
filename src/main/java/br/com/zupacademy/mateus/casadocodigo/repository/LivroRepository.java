package br.com.zupacademy.mateus.casadocodigo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.mateus.casadocodigo.model.Livro;
import br.com.zupacademy.mateus.casadocodigo.model.response.SimpleLivroResponse;

/**
 * 
 * Essa classe implementa as operações padrões de CRUD para a classe modelo Livro.
 * 
 * @author Mateus Soares
 */
@Repository
public interface LivroRepository extends CrudRepository<Livro, Long> {
	
	/**
	 * Procura por uma lista de livro populado com os ids e titulos cadastrados.
	 * 
	 * @return objeto List de livros populados com o id e título.
	 */
	@Query(value = "SELECT l.id, l.titulo FROM livro l ORDER BY l.id", nativeQuery = true)
	List<SimpleLivroResponse> selectIdTituloFromLivro();
}
