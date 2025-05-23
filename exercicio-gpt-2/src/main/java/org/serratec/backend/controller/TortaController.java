package org.serratec.backend.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.entity.Torta;
import org.serratec.backend.repository.TortaRepository;
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
@RequestMapping("/torta")
public class TortaController {

	@Autowired
	private TortaRepository repository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Torta inserir(@Valid @RequestBody Torta torta) {
		return repository.save(torta);
	}

	@GetMapping
	public List<Torta> listar() {
		return repository.findAll();
	}

	@GetMapping("{id}")
	public ResponseEntity<Torta> listarPorId(@PathVariable Long id) {
		Optional<Torta> torta = repository.findById(id);
		if (!torta.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(torta.get());
	}

	@PostMapping("/lista")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Torta> inserir(@Valid @RequestBody List<Torta> torta) {
		return repository.saveAll(torta);

	}

	@PutMapping("{id}")
	public ResponseEntity<Torta> atualizar(@PathVariable Long id, @Valid @RequestBody Torta torta) {
		if (repository.existsById(id)) {
			torta.setId(id);
			return ResponseEntity.ok(repository.save(torta));
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

