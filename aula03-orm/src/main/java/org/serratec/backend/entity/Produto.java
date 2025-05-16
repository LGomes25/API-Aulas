package org.serratec.backend.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
//@Table(name="tbl_produto") => para mudar o nome da tabela no BD
public class Produto {
	
	@Id		 //especifica a PK da entidade
	@GeneratedValue(strategy = GenerationType.IDENTITY)			//cria o sequencial do Id para a PK
	private Long id;
	
	@Column(length = 100,nullable = false)			//defini propriedades das colunas, não é obrigatorio
	private String descricao;
	
	@Column(nullable = false)			
	private Double valor;
	
	private LocalDate dataCadastro;		//sem a anotação de coluna
	
	//private transient Integer total;		// transiente => não será enviado para o banco, 
	
	
	//toString
	@Override
	public String toString() {
		return "Produto [id=" + id + ", descricao=" + descricao + ", valor=" + valor + ", dataCadastro=" + dataCadastro
				+ "]";
	}
	
	//Getters Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
}
