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

import br.com.zupacademy.mateus.casadocodigo.model.Cliente;
import br.com.zupacademy.mateus.casadocodigo.model.request.ClienteRequest; 
import br.com.zupacademy.mateus.casadocodigo.model.response.ClienteResponse;

/**
 * 
 * Controller com os end-points relacionados ao cadastro da entidade Cliente.
 * 
 * @author Mateus Soares
 */
@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@PersistenceContext
	private EntityManager manager;
	
	/**
	 * End-point de URL /clientes que realiza a validação e cadastro do registro de um cliente.
	 * 
	 * @param clienteRequest cliente a ser cadastrado.
	 * @return ResponseEntity representando o status HTTP 200, 400 ou 500.
	 */
	@PostMapping
	@Transactional
	public ResponseEntity<ClienteResponse> cadastrar(@RequestBody @Valid ClienteRequest clienteRequest) {
		Cliente cliente = clienteRequest.toModel(manager);
		manager.persist(cliente);
		return ResponseEntity.ok().body(new ClienteResponse(cliente));
	}
}
