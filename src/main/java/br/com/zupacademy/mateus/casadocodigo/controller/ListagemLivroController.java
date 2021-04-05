package br.com.zupacademy.mateus.casadocodigo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.mateus.casadocodigo.model.Livro;
import br.com.zupacademy.mateus.casadocodigo.model.response.LivroResponse;
import br.com.zupacademy.mateus.casadocodigo.model.response.SimpleLivroResponse;
import br.com.zupacademy.mateus.casadocodigo.repository.LivroRepository;

/**
 * 
 * Controller com os end-points relacionados a listagem da entidade Livro.
 * 
 * @author Mateus Soares
 */
@RestController
@RequestMapping("/livros")
public class ListagemLivroController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	/**
	 * End-point de URL /livros que realiza a listagem dos nomes e ids dos livros cadastrados.
	 * 
	 * @param livroRequest livro a ser cadastrado.
	 * @return ResponseEntity representando o status HTTP 200 ou 500.
	 */
	@GetMapping
	public ResponseEntity<List<SimpleLivroResponse>> listar() {
		List<SimpleLivroResponse> responseList = livroRepository.selectIdTituloFromLivro();
		return ResponseEntity.ok().body(responseList);
	}
	
	/**
	 * End-point de URL /livros/{id} que realiza a pesquisa pelo id de um livro, retornando o registro se for encontrado.
	 * 
	 * @param id id passado no path.
	 * @return ResponseEntity representando o status HTTP 200, 404 ou 500.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<LivroResponse> detalhar(@PathVariable Long id) {
		Optional<Livro> livroOptional = livroRepository.findById(id);
		if(livroOptional.isEmpty())
			return ResponseEntity.notFound().build();
		LivroResponse response = new LivroResponse(livroOptional.get());
		return ResponseEntity.ok().body(response);
	}
}
