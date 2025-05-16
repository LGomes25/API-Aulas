package org.serratec.backend.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.entity.Produto;
import org.serratec.backend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired									//gerencia as instancias diretamente no spring
	private ProdutoRepository repository;
	
	@GetMapping									//listar produtos => teste: http://localhost:8080/produtos
	public List<Produto> listar(){
		return repository.findAll();
	}
	
	@GetMapping("{id}")													//listar produto por id => teste: http://localhost:8080/produtos/2
	public ResponseEntity<Produto> listarPorId(@PathVariable Long id){  //Response Entity para trabalhar nas classes de respostas 200/400
		Optional<Produto> produto = repository.findById(id);    
		if(!produto.isPresent()) {
			return ResponseEntity.notFound().build();					//mensagem 404 - não encontrado
		}
		return ResponseEntity.ok(produto.get());						//mensagem 200 encontrado - e a resposta
	}
		
	
	@PostMapping								//insere produto => teste: http://localhost:8080/produtos
	@ResponseStatus(HttpStatus.CREATED)			//altera a mensagem para 201 para resposta
	public Produto inserir(@RequestBody Produto produto) {
		return repository.save(produto);		//salva dados no banco
	}
	
	@PostMapping("/varios")						//insere vários produtos => teste: http://localhost:8080/produtos/varios
	@ResponseStatus(HttpStatus.CREATED)
	public List<Produto> inserir(@RequestBody List<Produto> produtos){
		return repository.saveAll(produtos);
	}
	
	@PutMapping ("{id}")						//Altera produto por id => teste: http://localhost:8080/produtos/1
	public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto produto){ 
//		if (repository.findById(id).isPresent()) {				//é o select do sql
		if (repository.existsById(id)) {						//é o select do sql
			produto.setId(id);
			return ResponseEntity.ok(repository.save(produto));	//salva e retorna mensagem 201
		}
		return ResponseEntity.notFound().build();  				//mensagem 404 - não encontrado
	}
	
	@DeleteMapping("/{id}")						//Deleta produto por id => teste: http://localhost:8080/produtos/4
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	
	
	
}
