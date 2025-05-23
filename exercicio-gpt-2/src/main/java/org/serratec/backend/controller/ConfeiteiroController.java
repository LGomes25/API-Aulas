package org.serratec.backend.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.entity.Confeiteiro;
import org.serratec.backend.repository.ConfeiteiroRepository;
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
@RequestMapping("/confeiteiro")
public class ConfeiteiroController {

	@Autowired
	private ConfeiteiroRepository repository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Confeiteiro inserir(@Valid @RequestBody Confeiteiro confeiteiro) {
		return repository.save(confeiteiro);
	}

	@GetMapping
	public List<Confeiteiro> listar() {
		return repository.findAll();
	}

	@GetMapping("{id}")
	public ResponseEntity<Confeiteiro> listarPorId(@PathVariable Long id) {
		Optional<Confeiteiro> confeiteiro = repository.findById(id);
		if (!confeiteiro.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(confeiteiro.get());
	}

	@PostMapping("/lista")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Confeiteiro> inserir(@Valid @RequestBody List<Confeiteiro> confeiteiro) {
		return repository.saveAll(confeiteiro);

	}

	@PutMapping("{id}")
	public ResponseEntity<Confeiteiro> atualizar(@PathVariable Long id, @Valid @RequestBody Confeiteiro confeiteiro) {
		if (repository.existsById(id)) {
			confeiteiro.setId(id);
			return ResponseEntity.ok(repository.save(confeiteiro));
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

