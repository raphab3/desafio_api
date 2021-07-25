package br.com.backend.desafio_api.modules.clients.services;

import br.com.backend.desafio_api.modules.clients.entities.Client;
import br.com.backend.desafio_api.modules.clients.infra.dtos.ClientCreateDto;
import br.com.backend.desafio_api.modules.clients.infra.dtos.ClientDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IClientService {

    List<ClientDto> findAll();

    Page<Client> findPage(Integer page, Integer size, String direction, String orderBy);

    ClientDto findById(Long id);

    Client insert(ClientCreateDto obj);

    void update(Long id, Client obj);

    void delete(Long id);

}
