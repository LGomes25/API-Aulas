package org.serratec.backend.enums;

import org.serratec.backend.exception.EnumException;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Combustivel {

	DIESEL(1, "Diesel"), FLEX(2, "Flex"), GASOLINA(3, "Gasolina");

	private Integer codigo;
	private String tipo;

	// Construtor
	private Combustivel(Integer codigo, String tipo) {
		this.codigo = codigo;
		this.tipo = tipo;
	}

	// Getters Setters
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@JsonCreator
	public static Combustivel verificaCombustivel(Integer valor) {
		for (Combustivel combustivel : Combustivel.values()) {
			if (valor.equals(combustivel.getCodigo())) {
				return combustivel;
			}
		}
		throw new EnumException("Combustivel de carro inválida");
	}

}
