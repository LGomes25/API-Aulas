package org.serratec.backend.dto;

import java.time.LocalDate;

import org.serratec.backend.entity.Funcionario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FuncionarioResponseDTO {

	private Long id;
	private String nome;
	private LocalDate dataNascimento;
	private Double salario;
	
	public FuncionarioResponseDTO(Funcionario funcionario) {
		this.id = funcionario.getId();
		this.nome = funcionario.getNome();
		this.dataNascimento = funcionario.getDataNascimento();
		this.salario = funcionario.getSalario();
	}
	
	
	
}
