package org.serratec.backend.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Festa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Nome do evento não pode ser em branco")
	@Column(nullable = false)
	private String nomeDoEvento;
	
	@NotNull(message = "Data do evento não pode estar em branco")
	@FutureOrPresent(message = "Data não pode ser no passado")
	private LocalDate data;
	
	@ManyToMany
	@JoinTable(
		    name = "festa_bolo", 									// Nome da tabela de junção no banco
		    joinColumns = @JoinColumn(name = "festa_id"), 			// Coluna que referencia a Festa
		    inverseJoinColumns = @JoinColumn(name = "bolo_id")		// Coluna que referencia o Bolo
		)
	private List<Bolo> bolos;
	
}
