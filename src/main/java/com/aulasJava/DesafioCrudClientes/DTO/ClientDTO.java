package com.aulasJava.DesafioCrudClientes.DTO;

import java.time.LocalDate;

import com.aulasJava.DesafioCrudClientes.entities.Client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

public class ClientDTO {
	private Long id;
	@NotBlank(message = "Campo requerido!")
	private String name;
	private String cpf;
	private double income;
	@PastOrPresent(message = "Precisa ser no passado ou presente!")
	private LocalDate birthDate;
	private Integer children;

	public ClientDTO(Long id, String name, String cpf, double income, LocalDate birthDate, Integer children) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.birthDate = birthDate;
		this.children = children;
	}

	public ClientDTO(Client client) {
		this.id = client.getId();
		this.name = client.getName();
		this.cpf = client.getCpf();
		this.income = client.getIncome();
		this.birthDate = client.getBirthDate();
		this.children = client.getChildren();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCpf() {
		return cpf;
	}

	public double getIncome() {
		return income;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public Integer getChildren() {
		return children;
	}

}
