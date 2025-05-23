package org.serratec.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Bolo extends ProdutoConfeitaria{

	@NotBlank(message = "Necessário informação sobre a cobertura")
	@Column(nullable = false)
	private String cobertura;
	
	@NotNull(message = "Necessário dizer se terá ou não recheio")
	private Boolean recheado;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_confeiteiro")
	private Confeiteiro confeiteiro;
	
}
