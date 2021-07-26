package br.com.backend.desafio_api.modules.clients.services;

import br.com.backend.desafio_api.modules.clients.entities.Client;
import br.com.backend.desafio_api.modules.clients.infra.dtos.ClientDto;
import br.com.backend.desafio_api.modules.clients.infra.dtos.ClientPersistDto;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IClientService {

    ResponseEntity<List<Client>> findAll();

    Page<Client> findPage(Integer page, Integer size, String direction, String orderBy);

    ClientDto findByIdOrThrowBadRequestException(Long id);

    Client insert(ClientPersistDto clientPersistDto);

    void update(Long id, ClientPersistDto clientPersistDto);

    void delete(Long id);

}
