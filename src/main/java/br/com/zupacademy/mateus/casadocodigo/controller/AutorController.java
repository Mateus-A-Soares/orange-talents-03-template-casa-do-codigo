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

import br.com.zupacademy.mateus.casadocodigo.model.Autor;
import br.com.zupacademy.mateus.casadocodigo.model.request.AutorRequest;
import br.com.zupacademy.mateus.casadocodigo.model.response.AutorResponse;

/**
 * 
 * Controller com os end-points relacionados ao CRUD da entidade Autor.
 * 
 * @author Mateus Soares
 *
 */
@RestController
@RequestMapping("/autores")
public class AutorController {

	@PersistenceContext
	private EntityManager manager;
	
	/**
	 * End-point de URL /autores - Recebe um objeto JSON no corpo da
	 * requisição, que representa um autor a ser cadastrado, valida
	 * e tenta persistir, se o processo ocorrer com sucesso retorna
	 * o status 200 com o autor cadastrado no corpo da resposta.
	 * 
	 * @param autorRequest autor a ser cadastrado.
	 * @return ResponseEntity representando o status HTTP 200, 400 ou 500.
	 */
	@PostMapping
	@Transactional
	public ResponseEntity<AutorResponse> cadastrar(@RequestBody @Valid AutorRequest autorRequest) {
		Autor autor = autorRequest.toModel();
		manager.persist(autor);
		return ResponseEntity.ok().body(new AutorResponse(autor));
	}
}
