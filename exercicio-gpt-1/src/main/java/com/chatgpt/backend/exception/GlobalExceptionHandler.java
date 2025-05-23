package com.chatgpt.backend.exception;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleEntityNotFound(EntityNotFoundException ex, HttpServletRequest request) {
	    ErrorResponse error = new ErrorResponse(
	        LocalDateTime.now(),
	        HttpStatus.NOT_FOUND.value(),
	        "Entidade não encontrada",
	        ex.getMessage(),
	        request.getRequestURI()
	    );
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleResponseEntity(MethodArgumentNotValidException ex, HttpServletRequest request) {
		String mensagemErro = ex.getBindingResult().getFieldError().getDefaultMessage(); //pega a mensagem de erro
		
		ErrorResponse erro = new ErrorResponse( //chama a classe com o json criado
		    LocalDateTime.now(),
		    HttpStatus.BAD_REQUEST.value(),
		    "Erro de validação",
		    mensagemErro,
		    request.getRequestURI()
		);
		return ResponseEntity.badRequest().body(erro);

	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorResponse> handleMessageResponseEntity(HttpMessageNotReadableException ex, HttpServletRequest request){
		
		ErrorResponse erro = new ErrorResponse( //chama a classe com o json criado
		    LocalDateTime.now(),
		    HttpStatus.BAD_REQUEST.value(),
		    "JSON inválido ou mal formatado",
		    ex.getMessage(),
		    request.getRequestURI()
		);
		return ResponseEntity.badRequest().body(erro);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorResponse> handleConstrainResponseEntity(ConstraintViolationException ex, HttpServletRequest request){
		
		String mensagemErro = ex.getConstraintViolations()
	        .stream()
	        .map(v -> v.getPropertyPath() + ": " + v.getMessage())
	        .collect(Collectors.joining("; "));
		
		ErrorResponse erro = new ErrorResponse( //chama a classe com o json criado
		    LocalDateTime.now(),
		    HttpStatus.BAD_REQUEST.value(),
		    "Violação de restrições nos parâmetros da requisição",
		    mensagemErro,
		    request.getRequestURI()
		);
		return ResponseEntity.badRequest().body(erro);
		
	}
	
}
