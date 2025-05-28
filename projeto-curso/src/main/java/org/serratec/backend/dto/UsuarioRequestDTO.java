package org.serratec.backend.dto;

import java.util.HashSet;
import java.util.Set;

import org.serratec.backend.entity.Usuario;
import org.serratec.backend.entity.UsuarioPerfil;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
	
	@NotBlank(message = "O CEP é obrigatório.")
    @Pattern(regexp = "\\d{8}", message = "CEP inválido. Deve conter exatamente 8 dígitos numéricos sem traço!!!!!!")
    private String cep;

	private Set<UsuarioPerfil> usuarioPerfis = new HashSet<>();

	
//	construtor cheio, o vazio esta como lombock
	public UsuarioRequestDTO(Usuario usuario) {
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
	}
	
//	construtor para requisitar a informacao do cep
	public UsuarioRequestDTO(String nome, String email, String senha, Set<UsuarioPerfil> usuarioPerfis, String cep) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.usuarioPerfis = usuarioPerfis;
        this.cep = cep;
    }
	
}
