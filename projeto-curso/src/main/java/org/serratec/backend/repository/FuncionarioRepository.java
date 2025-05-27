package org.serratec.backend.repository;


import org.serratec.backend.entity.Funcionario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import java.util.List;


public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

//	@Query(value = "select * from funcionario where salario between :faixa1 and :faixa2", nativeQuery = true)
//	Page<Funcionario> faixaSalarial(Double faixa1, Double faixa2, Pageable peageble);
//
//	@Query(value = "select * from funcionario where nome ilike concat('%', :nome, '%')", nativeQuery = true)
//	Page<Funcionario> buscarPorNome(String nome, Pageable peageble);
	
	Page<Funcionario> findBySalarioBetween(Double faixa1, Double faixa2, Pageable peageble);
	
	Page<Funcionario> findByNomeContainsIgnoringCase(String nome, Pageable peageble);
	
}
