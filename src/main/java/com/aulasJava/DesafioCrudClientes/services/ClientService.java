package com.aulasJava.DesafioCrudClientes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aulasJava.DesafioCrudClientes.DTO.ClientDTO;
import com.aulasJava.DesafioCrudClientes.Exceptions.DatabaseException;
import com.aulasJava.DesafioCrudClientes.Exceptions.ResourceNotFoundException;
import com.aulasJava.DesafioCrudClientes.entities.Client;
import com.aulasJava.DesafioCrudClientes.repositories.ClientRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {
	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Client client = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!"));
		return new ClientDTO(client);
	}

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAll(Pageable pageable) {
		return repository.findAll(pageable).map(x -> new ClientDTO(x));
	}

	@Transactional
	public ClientDTO insert(ClientDTO clientDto) {
		Client client = new Client();
		DtoToClient(clientDto, client);
		return new ClientDTO(repository.save(client));
	}

	@Transactional
	public ClientDTO update(Long id, ClientDTO clientDto) {
		try {
			Client client = repository.getReferenceById(id);
			DtoToClient(clientDto, client);
			return new ClientDTO(repository.save(client));
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Recurso não encontrado!");
		}

	}

	@Transactional
	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("Recurso não encontrado!");
		}
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Falha na integridade referencial!");
		}
	}

	public void DtoToClient(ClientDTO dto, Client client) {
		client.setName(dto.getName());
		client.setIncome(dto.getIncome());
		client.setCpf(dto.getCpf());
		client.setChildren(dto.getChildren());
		client.setBirthDate(dto.getBirthDate());
	}

}
