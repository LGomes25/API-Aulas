package org.serratec.backend.revisao;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ExemploController {

	@GetMapping
	public String test(@RequestParam String nome) { // Para testar: http://localhost:8080/api/v1?nome=leonardo
		return nome.toUpperCase();
	}
	
	@GetMapping("/test")
	public String test2() { // Para testar: http://localhost:8080/api/v1/test
		return "Java";
	}

	//Criar método para retornar a soma de dois numeros
	@GetMapping("/soma") //retorna um inteiro
	public Integer soma(@RequestParam Integer n1, Integer n2) { // Para testar: http://localhost:8080/api/v1/soma?n1=89&n2=11
		return n1+n2;
	}
	
	@GetMapping("/soma2") //retorna uma string
	public String soma2(@RequestParam Integer n1, Integer n2) { // Para testar: http://localhost:8080/api/v1/soma2?n1=89&n2=11
		return "Soma = " +  (n1+n2);
	}
	
}
