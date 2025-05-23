package com.chatgpt.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatgpt.backend.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
