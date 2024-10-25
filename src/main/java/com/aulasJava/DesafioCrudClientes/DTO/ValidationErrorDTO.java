package com.aulasJava.DesafioCrudClientes.DTO;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationErrorDTO extends CustomErrorDTO {

	private List<ErrorDTO> errors = new ArrayList<>();

	public ValidationErrorDTO(Instant timeStamp, Integer status, String error, String path) {
		super(timeStamp, status, error, path);
	}

	public List<ErrorDTO> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String message) {
		errors.add(new ErrorDTO(fieldName, message));
	}
}
