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

import br.com.zupacademy.mateus.casadocodigo.model.Categoria;
import br.com.zupacademy.mateus.casadocodigo.model.request.CategoriaRequest;
import br.com.zupacademy.mateus.casadocodigo.model.response.CategoriaResponse;

/**
 * 
 * Controller com os end-points relacionados ao CRUD da entidade Categoria.
 * 
 * @author Mateus Soares
 */
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@PersistenceContext
	private EntityManager manager;
	
	/**
	 * End-point de URL /categorias - Recebe um objeto JSON no corpo da
	 * requisição, que representa uma categoria a ser cadastrada, valida
	 * e tenta persistir, se o processo ocorrer com sucesso retorna
	 * o status 200 com a categoria cadastrada no corpo da resposta.
	 * 
	 * @param categoriaRequest categoria a ser cadastrada.
	 * @return ResponseEntity representando o status HTTP 200, 400 ou 500.
	 */
	@PostMapping
	@Transactional
	public ResponseEntity<CategoriaResponse> cadastrar(@RequestBody @Valid CategoriaRequest categoriaRequest) {
		Categoria categoria = categoriaRequest.toModel();
		manager.persist(categoria);
		return ResponseEntity.ok().body(new CategoriaResponse(categoria));
	}
}
