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

import br.com.zupacademy.mateus.casadocodigo.model.Estado;
import br.com.zupacademy.mateus.casadocodigo.model.request.EstadoRequest;
import br.com.zupacademy.mateus.casadocodigo.model.response.EstadoResponse;

/**
 * 
 * Controller com os end-points relacionados ao CRUD da entidade Estado.
 * 
 * @author Mateus Soares
 */
@RestController
@RequestMapping("/estados")
public class EstadoController {

	@PersistenceContext
	private EntityManager manager;
	
	/**
	 * End-point de URL /estadoes que realiza a validação e cadastro do registro de um estado.
	 * 
	 * @param estadoRequest estado a ser cadastrado.
	 * @return ResponseEntity representando o status HTTP 200, 400 ou 500.
	 */
	@PostMapping
	@Transactional
	public ResponseEntity<EstadoResponse> cadastrar(@RequestBody @Valid EstadoRequest estadoRequest) {
		Estado estado = estadoRequest.toModel(manager);
		manager.persist(estado);
		return ResponseEntity.ok().body(new EstadoResponse(estado));
	}
}
