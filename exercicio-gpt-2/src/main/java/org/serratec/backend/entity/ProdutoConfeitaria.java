package org.serratec.backend.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@MappedSuperclass
public class ProdutoConfeitaria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	
	@NotBlank(message = "Nome do produto não pode ser em branco")
	@Column(nullable = false)
	protected String nome;
	
	@NotNull(message = "Preço é obrigatório")
	@Column(precision = 19, scale = 2)
	protected BigDecimal preco;
	
	@NotBlank(message = "Ingredientes principais do produto não podem estar em branco")
	@Column(nullable = false)
	protected String ingredientesPrincipais;
}
