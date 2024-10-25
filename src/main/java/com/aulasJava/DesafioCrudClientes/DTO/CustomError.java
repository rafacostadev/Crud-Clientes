package com.aulasJava.DesafioCrudClientes.DTO;

import java.time.Instant;

public class CustomError {
	Instant timeStamp;
	Integer status;
	String error;
	String path;

	public CustomError(Instant timeStamp, Integer status, String error, String path) {
		super();
		this.timeStamp = timeStamp;
		this.status = status;
		this.error = error;
		this.path = path;
	}

	public Instant getTimeStamp() {
		return timeStamp;
	}

	public Integer getStatus() {
		return status;
	}

	public String getError() {
		return error;
	}

	public String getPath() {
		return path;
	}

}
