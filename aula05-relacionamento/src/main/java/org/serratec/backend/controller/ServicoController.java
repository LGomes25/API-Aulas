package org.serratec.backend.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.entity.Servico;
import org.serratec.backend.repository.ServicoRepository;
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
@RequestMapping("/servico")
public class ServicoController {

	@Autowired
	private ServicoRepository repository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Servico inserir(@Valid @RequestBody Servico servico) {
		return repository.save(servico);
	}

	@GetMapping
	public List<Servico> listar() {
		return repository.findAll();
	}

	@GetMapping("{id}")
	public ResponseEntity<Servico> listarPorId(@PathVariable Long id) {
		Optional<Servico> servico = repository.findById(id);
		if (!servico.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(servico.get());
	}

	@PostMapping("/lista")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Servico> inserir(@Valid @RequestBody List<Servico> servico) {
		return repository.saveAll(servico);

	}

	@PutMapping("{id}")
	public ResponseEntity<Servico> atualizar(@PathVariable Long id, @Valid @RequestBody Servico servico) {
		if (repository.existsById(id)) {
			servico.setId(id);
			return ResponseEntity.ok(repository.save(servico));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}

