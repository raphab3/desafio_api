package br.com.backend.desafio_api.modules.clients.services;

import br.com.backend.desafio_api.modules.clients.entities.Client;
import br.com.backend.desafio_api.modules.clients.infra.dtos.ClientCreateDto;
import br.com.backend.desafio_api.modules.clients.infra.dtos.ClientDto;
import br.com.backend.desafio_api.modules.clients.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<ClientDto> findAll() {
        List<Client> list = clientRepository.findAll();
        return list.stream().map(x -> new ClientDto(x)).collect(Collectors.toList());
    }

    @Override
    public Page<Client> findPage(Integer page, Integer size, String direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.valueOf(direction), orderBy);
        return clientRepository.findAll(pageRequest);
    }

    @Override
    public ClientDto findById(Long id) {
        Client client = clientRepository.findById(id).get();
        ClientDto clientListDto = new ClientDto(client);
        return clientListDto;
    }

    @Override
    public Client insert(ClientCreateDto clientCreateDto) {
        Client c = new Client();
        ClientCreateDto client = new ClientCreateDto(clientCreateDto);
        c.setName(client.getName());
        c.setCpf(client.getCpf());
        c.setBirthDate(client.getBirthDate());

        Client clientDto = clientRepository.save(c);
        return clientDto;
    }

    @Override
    public void update(Long id, Client obj) {
        Client client = clientRepository.findById(id).get();
        client.setName(obj.getName());
        client.setCpf(obj.getCpf());
        client.setBirthDate(obj.getBirthDate());
        clientRepository.save(client);
    }


    @Override
    public void delete(Long id) {
        Client client = clientRepository.findById(id).get();
        clientRepository.deleteById(client.getId());
    }
}
