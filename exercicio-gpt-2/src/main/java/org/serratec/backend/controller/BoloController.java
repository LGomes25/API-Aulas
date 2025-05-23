package org.serratec.backend.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.entity.Bolo;
import org.serratec.backend.repository.BoloRepository;
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
@RequestMapping("/bolo")
public class BoloController {

	@Autowired
	private BoloRepository repository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Bolo inserir(@Valid @RequestBody Bolo bolo) {
		return repository.save(bolo);
	}

	@GetMapping
	public List<Bolo> listar() {
		return repository.findAll();
	}

	@GetMapping("{id}")
	public ResponseEntity<Bolo> listarPorId(@PathVariable Long id) {
		Optional<Bolo> bolo = repository.findById(id);
		if (!bolo.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(bolo.get());
	}

	@PostMapping("/lista")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Bolo> inserir(@Valid @RequestBody List<Bolo> bolo) {
		return repository.saveAll(bolo);

	}

	@PutMapping("{id}")
	public ResponseEntity<Bolo> atualizar(@PathVariable Long id, @Valid @RequestBody Bolo bolo) {
		if (repository.existsById(id)) {
			bolo.setId(id);
			return ResponseEntity.ok(repository.save(bolo));
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

