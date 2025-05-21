package org.serratec.backend.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@MappedSuperclass
public abstract class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	protected String nome;
	protected String email;
	
}
