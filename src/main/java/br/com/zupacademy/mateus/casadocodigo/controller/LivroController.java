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

import br.com.zupacademy.mateus.casadocodigo.model.Livro;
import br.com.zupacademy.mateus.casadocodigo.model.request.LivroRequest;
import br.com.zupacademy.mateus.casadocodigo.model.response.LivroResponse;

/**
 * 
 * Controller com os end-points relacionados ao CRUD da entidade Livro.
 * 
 * @author Mateus Soares
 *
 */
@RestController
@RequestMapping("/livros")
public class LivroController {

	@PersistenceContext
	private EntityManager manager;
	
	/**
	 * End-point de URL /livros - Recebe um objeto JSON no corpo da
	 * requisição, que representa um livro a ser cadastrado, valida
	 * e tenta persistir, se o processo ocorrer com sucesso retorna
	 * o status 200 com o livro cadastrado no corpo da resposta.
	 * 
	 * @param livroRequest livro a ser cadastrado.
	 * @return ResponseEntity representando o status HTTP 200, 400 ou 500.
	 */
	@PostMapping
	@Transactional
	public ResponseEntity<LivroResponse> cadastrar(@RequestBody @Valid LivroRequest livroRequest) {
		Livro livro = livroRequest.toModel(manager);
		manager.persist(livro);
		return ResponseEntity.ok().body(new LivroResponse(livro));
	}
}
