package org.serratec.backend.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class PessoaJuridica extends Fornecedor {

	private String razaoSocial;
	private String cnpj;
	private String inscricaoEstadual;
	
	
}
