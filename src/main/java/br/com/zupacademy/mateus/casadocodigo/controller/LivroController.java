package br.com.zupacademy.mateus.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.mateus.casadocodigo.model.Livro; // 1 Ponto de CI
import br.com.zupacademy.mateus.casadocodigo.model.request.LivroRequest; // 2 Pontos de CI
import br.com.zupacademy.mateus.casadocodigo.model.response.LivroResponse; // 3 Pontos de CI

/**
 * 
 * Controller com os end-points relacionados ao cadastro da entidade Livro.
 * 
 * @author Mateus Soares
 */
@RestController
@RequestMapping("/livros")
public class LivroController {
	
	// 4 pontos de Carga Intrínseca 

	@PersistenceContext
	private EntityManager manager;
	
	/**
	 * End-point de URL /livros que realiza a validação e cadastro do registro de um livro.
	 * 
	 * @param livroRequest livro a ser cadastrado.
	 * @return ResponseEntity representando o status HTTP 200, 400 ou 500.
	 */
	@PostMapping
	@Transactional
	public ResponseEntity<LivroResponse> cadastrar(@RequestBody @Valid LivroRequest livroRequest) { // 4 Pontos de CI
		Livro livro = livroRequest.toModel(manager);
		manager.persist(livro);
		return ResponseEntity.ok().body(new LivroResponse(livro));
	}
}
