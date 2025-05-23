package com.chatgpt.backend.test;

public class TesteLombock {

	public static void main(String[] args) {
		
		Pessoa p = new Pessoa("Ana", 28);
        System.out.println(p);  // Vai usar o toString gerado pelo Lombok
        p.setIdade(29);
        System.out.println("Nova idade: " + p.getIdade());

	}

}
