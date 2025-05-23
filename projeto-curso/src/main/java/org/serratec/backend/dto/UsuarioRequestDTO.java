package org.serratec.backend.dto;

import java.util.HashSet;
import java.util.Set;

import org.serratec.backend.entity.Usuario;
import org.serratec.backend.entity.UsuarioPerfil;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class UsuarioRequestDTO {

	@NotBlank
	private String nome;

	@Email
	private String email;

	@NotBlank
	private String senha;

	private Set<UsuarioPerfil> usuarioPerfis = new HashSet<>();

	public UsuarioRequestDTO(Usuario usuario) {
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
	}

}
