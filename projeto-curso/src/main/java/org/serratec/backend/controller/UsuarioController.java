package org.serratec.backend.controller;

import java.util.List;

import org.serratec.backend.dto.UsuarioRequestDTO;
import org.serratec.backend.dto.UsuarioResponseDTO;
import org.serratec.backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public ResponseEntity<List<UsuarioResponseDTO>> listar(){
		return ResponseEntity.ok(service.listar());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioResponseDTO inserir(@RequestBody UsuarioRequestDTO usuario) {
		return service.inserir(usuario);
	}
	
}
