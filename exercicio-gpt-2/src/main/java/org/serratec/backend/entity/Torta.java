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
public class Torta extends ProdutoConfeitaria {

	@NotBlank(message = "Necessário informação sobre tipo de massa")
	@Column(nullable = false)
	private String tipoMassa;
	
	@NotNull(message = "Necessário dizer se será gelada ou não")
	private Boolean gelada;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_confeiteiro")
	private Confeiteiro confeiteiro;
}
