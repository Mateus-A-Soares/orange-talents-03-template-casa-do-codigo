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

import br.com.zupacademy.mateus.casadocodigo.model.Pais;
import br.com.zupacademy.mateus.casadocodigo.model.request.PaisRequest;
import br.com.zupacademy.mateus.casadocodigo.model.response.PaisResponse;

/**
 * 
 * Controller com os end-points relacionados ao CRUD da entidade Pais.
 * 
 * @author Mateus Soares
 */
@RestController
@RequestMapping("/paises")
public class PaisController {

	@PersistenceContext
	private EntityManager manager;
	
	/**
	 * End-point de URL /paises que realiza a validação e cadastro do registro de um pais.
	 * 
	 * @param paisRequest pais a ser cadastrado.
	 * @return ResponseEntity representando o status HTTP 200, 400 ou 500.
	 */
	@PostMapping
	@Transactional
	public ResponseEntity<PaisResponse> cadastrar(@RequestBody @Valid PaisRequest paisRequest) {
		Pais pais = paisRequest.toModel();
		manager.persist(pais);
		return ResponseEntity.ok().body(new PaisResponse(pais));
	}
}
