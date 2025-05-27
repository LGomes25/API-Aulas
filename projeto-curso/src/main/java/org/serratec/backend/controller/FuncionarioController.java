package org.serratec.backend.controller;

import java.util.List;

import org.serratec.backend.dto.FuncionarioResponseDTO;
import org.serratec.backend.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService service;
	
	@GetMapping
	public List<FuncionarioResponseDTO> listar(){
		return service.listar();
	}
	
	@GetMapping("/pagina")
	public Page<FuncionarioResponseDTO> listarPorPagina(@PageableDefault(page = 1, size = 10, sort = {"nome","salario"},direction = Direction.DESC) Pageable pageable) {
		return service.listarPorPagina(pageable);
	}
	
	@GetMapping("/faixa")
	public Page<FuncionarioResponseDTO> listarPorFaixaSalarial(@RequestParam(defaultValue = "1000") Double faixa1, @RequestParam(defaultValue = "2000") Double faixa2, Pageable pageable){
		return service.listarPorPaginaFaixaSalarial(faixa1, faixa2, pageable);
	}
	
	@GetMapping("/nome")
	public Page<FuncionarioResponseDTO> listarPorNome(@RequestParam(defaultValue = "") String nome, Pageable pageable){
		return service.listarPorNome(nome, pageable);
	}
	
}
