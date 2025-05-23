package org.serratec.backend.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.entity.Cupcake;
import org.serratec.backend.repository.CupcakeRepository;
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
@RequestMapping("/cupcake")
public class CupcakeController {

	@Autowired
	private CupcakeRepository repository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cupcake inserir(@Valid @RequestBody Cupcake cupcake) {
		return repository.save(cupcake);
	}

	@GetMapping
	public List<Cupcake> listar() {
		return repository.findAll();
	}

	@GetMapping("{id}")
	public ResponseEntity<Cupcake> listarPorId(@PathVariable Long id) {
		Optional<Cupcake> cupcake = repository.findById(id);
		if (!cupcake.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cupcake.get());
	}

	@PostMapping("/lista")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Cupcake> inserir(@Valid @RequestBody List<Cupcake> cupcake) {
		return repository.saveAll(cupcake);

	}

	@PutMapping("{id}")
	public ResponseEntity<Cupcake> atualizar(@PathVariable Long id, @Valid @RequestBody Cupcake cupcake) {
		if (repository.existsById(id)) {
			cupcake.setId(id);
			return ResponseEntity.ok(repository.save(cupcake));
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

