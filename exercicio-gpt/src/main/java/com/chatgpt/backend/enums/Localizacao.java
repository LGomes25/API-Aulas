package com.chatgpt.backend.enums;

public enum Localizacao {

	FABRICA(1,"Fábrica"),
	ADMINISTRATIVO(2,"Administrativo"),
	GERENCIA(3,"Gerência");
	
	private Integer codigo;
	private String local;
	
	//construtor
	private Localizacao(Integer codigo, String local) {
		this.codigo = codigo;
		this.local = local;
	}

	//Getters
	public Integer getCodigo() {
		return codigo;
	}

	public String getLocal() {
		return local;
	}
	
	
	
}
