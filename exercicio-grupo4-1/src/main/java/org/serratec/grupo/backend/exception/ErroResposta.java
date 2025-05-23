package org.serratec.grupo.backend.exception;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ErroResposta {

	private Integer status;
	private String titulo;
	private LocalDateTime dataHora;
	private List<String> erros;
	
}
