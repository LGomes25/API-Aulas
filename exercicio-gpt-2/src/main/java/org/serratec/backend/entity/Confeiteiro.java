package org.serratec.backend.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Confeiteiro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "Nome não pode ser em branco")
	@Column(nullable = false)
	private String nome;
	
	@NotBlank(message = "Especialidades não pode ser em branco")
	@Column(nullable = false)
	private String especialidade;
	
	@JsonIgnore
	@JsonManagedReference(value = "bolo-confeiteiro")
	@OneToMany(mappedBy = "confeiteiro")
	private List<Bolo> bolos;

	@JsonIgnore
	@JsonManagedReference(value = "cupcake-confeiteiro")
	@OneToMany(mappedBy = "confeiteiro")
	private List<Cupcake> cupcakes;
	
	@JsonIgnore
	@JsonManagedReference(value = "torta-confeiteiro")
	@OneToMany(mappedBy = "confeiteiro")
	private List<Torta> tortas;
}
