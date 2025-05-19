package org.serratec.backend.enums;

import org.serratec.backend.exception.EnumException;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Categoria {

	SUV, HATCH, PICAPE, SEDAN, CONVERSIVEL, COUPE;
	
	@JsonCreator
	public static Categoria verificaCategoria(String valor) {
		for (Categoria categoria: Categoria.values()) {
			if (valor.equals(categoria.name())) {
				return categoria;
			}
		}
		throw new EnumException("Categoria de carro inválida");
	}
}
