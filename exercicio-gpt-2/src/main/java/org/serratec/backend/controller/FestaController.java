package org.serratec.backend.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.entity.Festa;
import org.serratec.backend.repository.FestaRepository;
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
@RequestMapping("/festa")
public class FestaController {

	@Autowired
	private FestaRepository repository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Festa inserir(@Valid @RequestBody Festa festa) {
		return repository.save(festa);
	}

	@GetMapping
	public List<Festa> listar() {
		return repository.findAll();
	}

	@GetMapping("{id}")
	public ResponseEntity<Festa> listarPorId(@PathVariable Long id) {
		Optional<Festa> festa = repository.findById(id);
		if (!festa.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(festa.get());
	}

	@PostMapping("/lista")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Festa> inserir(@Valid @RequestBody List<Festa> festa) {
		return repository.saveAll(festa);

	}

	@PutMapping("{id}")
	public ResponseEntity<Festa> atualizar(@PathVariable Long id, @Valid @RequestBody Festa festa) {
		if (repository.existsById(id)) {
			festa.setId(id);
			return ResponseEntity.ok(repository.save(festa));
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

