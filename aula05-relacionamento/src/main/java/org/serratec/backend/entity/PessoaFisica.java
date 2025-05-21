package org.serratec.backend.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class PessoaFisica extends Fornecedor {

	private String cpf;
	private String rg;
	private String orgaoExpedidor;
	
}
