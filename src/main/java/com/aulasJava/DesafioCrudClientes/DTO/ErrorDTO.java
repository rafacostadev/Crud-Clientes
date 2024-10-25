package com.aulasJava.DesafioCrudClientes.DTO;

public class ErrorDTO {
	private String fieldName;
	private String message;

	public ErrorDTO(String fieldName, String message) {
		this.fieldName = fieldName;
		this.message = message;
	}

	public String getFieldName() {
		return fieldName;
	}

	public String getMessage() {
		return message;
	}

}
