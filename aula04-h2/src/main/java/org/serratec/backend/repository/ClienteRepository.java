package org.serratec.backend.repository;

import java.util.UUID;

import org.serratec.backend.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, UUID>{

}
