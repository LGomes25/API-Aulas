package org.serratec.backend.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
