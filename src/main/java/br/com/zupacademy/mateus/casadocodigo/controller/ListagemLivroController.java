package br.com.zupacademy.mateus.casadocodigo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
