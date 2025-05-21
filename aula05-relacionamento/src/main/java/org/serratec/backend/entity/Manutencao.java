package org.serratec.backend.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Manutencao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private LocalDate dataEntrada;
	private LocalDate dataSaida;
	private String obs;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_veiculo")
	private Veiculo veiculo;

	@ManyToMany
	@JoinTable(name = "manutencao_servico",
	joinColumns = @JoinColumn(name = "id_manutencao"),
	inverseJoinColumns = @JoinColumn(name="id_servico"))
	private List<Servico> servicos;
	
}
