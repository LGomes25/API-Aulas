package com.chatgpt.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatgpt.backend.entity.Funcionario;
import com.chatgpt.backend.repository.FuncionarioRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository repository;
	
	@GetMapping
	public List<Funcionario> listar() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> listarId(@PathVariable Long id) {
	    return repository.findById(id)
	    		.map(ResponseEntity::ok)
	            .orElseThrow(() -> new EntityNotFoundException("Funcionário com ID " + id + " não encontrado"));
	}
	
	@PostMapping
	public Funcionario cadastra(@RequestBody @Valid Funcionario funcionario) {
		return repository.save(funcionario);
	}
	
	@PostMapping("/carga")
	public List<Funcionario> carregarLista(@RequestBody @Valid List<Funcionario> funcionarios){
		return repository.saveAll(funcionarios);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @RequestBody @Valid Funcionario funcionario) {
	    if (!repository.existsById(id)) {
	    	throw new EntityNotFoundException("Funcionário com ID " + id + " não encontrado");
	    } 
	    	funcionario.setId(id);
	    	return ResponseEntity.ok(repository.save(funcionario));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id){
		if (!repository.existsById(id)) {
			throw new EntityNotFoundException("Funcionário com ID " + id + " não encontrado");
		}else {
		repository.deleteById(id);
		return ResponseEntity.noContent().build(); //204 No Content
		}
	}
	
}
