package org.serratec.backend.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.entity.Manutencao;
import org.serratec.backend.repository.ManutencaoRepository;
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
@RequestMapping("/manutencao")
public class ManutencaoController {

	@Autowired
	private ManutencaoRepository repository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Manutencao inserir(@Valid @RequestBody Manutencao manutencao) {
		return repository.save(manutencao);
	}

	@GetMapping
	public List<Manutencao> listar() {
		return repository.findAll();
	}

	@GetMapping("{id}")
	public ResponseEntity<Manutencao> listarPorId(@PathVariable Long id) {
		Optional<Manutencao> manutencao = repository.findById(id);
		if (!manutencao.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(manutencao.get());
	}

	@PostMapping("/lista")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Manutencao> inserir(@Valid @RequestBody List<Manutencao> manutencao) {
		return repository.saveAll(manutencao);

	}

	@PutMapping("{id}")
	public ResponseEntity<Manutencao> atualizar(@PathVariable Long id, @Valid @RequestBody Manutencao manutencao) {
		if (repository.existsById(id)) {
			manutencao.setId(id);
			return ResponseEntity.ok(repository.save(manutencao));
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

