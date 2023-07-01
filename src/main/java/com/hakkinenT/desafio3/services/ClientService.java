package com.hakkinenT.desafio3.services;

import com.hakkinenT.desafio3.dto.ClientDTO;
import com.hakkinenT.desafio3.entities.Client;
import com.hakkinenT.desafio3.repositories.ClientRepository;
import com.hakkinenT.desafio3.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        Client client = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado."));
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto){
        Client client = new Client();
        copyDtoToEntity(dto, client);

        client = repository.save(client);
        return new ClientDTO(client);
    }

    private void copyDtoToEntity(ClientDTO dto, Client entity){
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
    }
}
