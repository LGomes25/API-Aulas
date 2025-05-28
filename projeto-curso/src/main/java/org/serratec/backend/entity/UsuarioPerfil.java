package org.serratec.backend.entity;

import java.time.LocalDate;

import org.serratec.backend.entity.PK.UsuarioPerfilPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class UsuarioPerfil {

	@EmbeddedId
	private UsuarioPerfilPK id = new UsuarioPerfilPK();

	private LocalDate dataCriacao;

	public UsuarioPerfil(Usuario usuario, Perfil perfil, LocalDate dataCriacao) {
		id.setUsuario(usuario);
		id.setPerfil(perfil);
		this.dataCriacao = dataCriacao;
	}
	
	@Override
	public String toString() {
		return "UsuarioPerfil [id=" + id + ", dataCriacao=" + dataCriacao + "]";
	}
	
	public void setUsuario(Usuario usuario) {
		id.setUsuario(usuario);
	}

	public Usuario getUsuario() {
		return id.getUsuario();
	}

	public void setPerfil(Perfil perfil) {
		id.setPerfil(perfil);
	}

	public Perfil getPerfil() {
		return id.getPerfil();
	}





}
