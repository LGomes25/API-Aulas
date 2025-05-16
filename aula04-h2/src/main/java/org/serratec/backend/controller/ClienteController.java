package org.serratec.backend.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.serratec.backend.entity.Cliente;
import org.serratec.backend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository repository;
	
	@GetMapping
	public List<Cliente> listar(){
		return repository.findAll();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Cliente> listarPorId(@PathVariable UUID id){
		Optional<Cliente> cliente = repository.findById(id);
		if(!cliente.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cliente.get());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente inserir(@Valid @RequestBody Cliente cliente) {
		return repository.save(cliente);
	}
	
	@PostMapping("/lista")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Cliente> inserir(@RequestBody List<Cliente> cliente){
		return repository.saveAll(cliente);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable UUID id,@RequestBody Cliente cliente){
		if(repository.existsById(id)) {
			cliente.setId(id);
			return ResponseEntity.ok(repository.save(cliente));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> remover(@PathVariable UUID id){
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
}
