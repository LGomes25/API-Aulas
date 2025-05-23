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
public class Cupcake extends ProdutoConfeitaria {

	@NotBlank(message = "Necessário informação sobre cor do granulado")
	@Column(nullable = false)
	private String corDoGranulado;
	
	@NotNull(message = "Necessário informação sobre quantidade por caixa")
	@Column(nullable = false)
	private Integer unidadesPorCaixa;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_confeiteiro")
	private Confeiteiro confeiteiro;
}
