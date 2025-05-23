package com.chatgpt.backend.entity;

import com.chatgpt.backend.enums.Cargo;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//uso lombok 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;
	
	@NotBlank
	private String nome;
	
	@Email @NotBlank
	private String email;
	
	@Enumerated(EnumType.STRING)
	private Cargo cargo;
	
	@Embedded
	private Departamento departamento;
	
}
