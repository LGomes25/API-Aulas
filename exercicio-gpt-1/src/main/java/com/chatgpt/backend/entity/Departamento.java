package com.chatgpt.backend.entity;

import com.chatgpt.backend.enums.Localizacao;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString


@Embeddable
public class Departamento {

	@NotNull
	private String nomeDpt;
	
	@Enumerated(EnumType.STRING)
	private Localizacao localizacao;

}
