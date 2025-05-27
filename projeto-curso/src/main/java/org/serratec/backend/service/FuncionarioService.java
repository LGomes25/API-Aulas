package org.serratec.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.backend.dto.FuncionarioResponseDTO;
import org.serratec.backend.entity.Funcionario;
import org.serratec.backend.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;
	
	public List<FuncionarioResponseDTO> listar(){
		List<Funcionario> funcionarios = repository.findAll();
		
		return funcionarios.stream().map(f-> new FuncionarioResponseDTO(f)).collect(Collectors.toList());
	}

	public Page<FuncionarioResponseDTO> listarPorPagina(Pageable pageable){
		Page<Funcionario> funcionarios = repository.findAll(pageable);
		return funcionarios.map(f-> new FuncionarioResponseDTO(f));
	}
	
	public Page<FuncionarioResponseDTO> listarPorPaginaFaixaSalarial(Double faixa1, Double faixa2, Pageable pageable){
		Page<Funcionario> funcionarios = repository.findBySalarioBetween(faixa1, faixa2, pageable);
		return funcionarios.map(f-> new FuncionarioResponseDTO(f));
	}
	
	public Page<FuncionarioResponseDTO> listarPorNome(String nome, Pageable pageable){
		Page<Funcionario> funcionarios = repository.findByNomeContainsIgnoringCase(nome, pageable);
		return funcionarios.map(f-> new FuncionarioResponseDTO(f));
	}
	
	
	
}
