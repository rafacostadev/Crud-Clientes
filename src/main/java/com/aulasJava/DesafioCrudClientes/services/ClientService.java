package com.aulasJava.DesafioCrudClientes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aulasJava.DesafioCrudClientes.ResourceNotFoundException;
import com.aulasJava.DesafioCrudClientes.DTO.ClientDTO;
import com.aulasJava.DesafioCrudClientes.entities.Client;
import com.aulasJava.DesafioCrudClientes.repositories.ClientRepository;

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
		Client client = repository.getReferenceById(id);
		DtoToClient(clientDto, client);
		return new ClientDTO(repository.save(client));
	}

	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}

	public void DtoToClient(ClientDTO dto, Client client) {
		client.setName(dto.getName());
		client.setIncome(dto.getIncome());
		client.setCpf(dto.getCpf());
		client.setChildren(dto.getChildren());
		client.setBirthDate(dto.getBirthDate());
	}

}
