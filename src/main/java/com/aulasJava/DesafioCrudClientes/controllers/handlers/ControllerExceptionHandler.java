package com.aulasJava.DesafioCrudClientes.controllers.handlers;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.aulasJava.DesafioCrudClientes.DTO.CustomErrorDTO;
import com.aulasJava.DesafioCrudClientes.DTO.ValidationErrorDTO;
import com.aulasJava.DesafioCrudClientes.Exceptions.DatabaseException;
import com.aulasJava.DesafioCrudClientes.Exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<CustomErrorDTO> resourceNotFoundException(ResourceNotFoundException e,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		CustomErrorDTO error = new CustomErrorDTO(Instant.now(), status.value(), e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}

	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<CustomErrorDTO> databaseException(DatabaseException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		CustomErrorDTO error = new CustomErrorDTO(Instant.now(), status.value(), e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<CustomErrorDTO> methodArgumentNotValidException(MethodArgumentNotValidException e,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
		ValidationErrorDTO error = new ValidationErrorDTO(Instant.now(), status.value(), "Erro na validação dos campos!",
				request.getRequestURI());
		for (FieldError f : e.getFieldErrors()) {
			error.addError(f.getField(), f.getDefaultMessage());
		}

		return ResponseEntity.status(status).body(error);
	}
}
