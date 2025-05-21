package org.serratec.backend.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Size(min = 7, max = 7, message = "Placa inválida")
	private String placa;
	
	@NotBlank
	private String marca;
	
	@NotBlank
	private String modelo;
	
	@Embedded								//incorpora o que está na classe caracteristica - união de classes
	private Caracteristica caracteristica;

	@OneToOne
	@JoinColumn(name = "id_proprietario")
	private Proprietario proprietario;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "veiculo")
	private List<Manutencao> manutencoes;
	
	
	
	public List<Manutencao> getManutencoes() {
		return manutencoes;
	}



	public void setManutencoes(List<Manutencao> manutencoes) {
		this.manutencoes = manutencoes;
	}



	public Proprietario getProprietario() {
		return proprietario;
	}
	
	

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	//Getters Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Caracteristica getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(Caracteristica caracteristica) {
		this.caracteristica = caracteristica;
	}
	
	
	
	
}
