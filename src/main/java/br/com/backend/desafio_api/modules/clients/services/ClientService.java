package br.com.backend.desafio_api.modules.clients.services;

import br.com.backend.desafio_api.modules.addresses.entities.Address;
import br.com.backend.desafio_api.modules.clients.entities.Client;
import br.com.backend.desafio_api.modules.clients.infra.dtos.ClientDto;
import br.com.backend.desafio_api.modules.clients.infra.dtos.ClientPersistDto;
import br.com.backend.desafio_api.modules.clients.infra.mapper.ClientMapper;
import br.com.backend.desafio_api.modules.clients.repositories.ClientRepository;
import br.com.backend.desafio_api.shared.exceptions.BadRequestExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientService implements IClientService {

    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;

    @Override
    public ResponseEntity<List<Client>> findAll() {
        return new ResponseEntity<>(clientRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public Page<Client> findPage(Integer page, Integer size, String direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.valueOf(direction), orderBy);
        return clientRepository.findAll(pageRequest);
    }

    @Override
    public ClientDto findByIdOrThrowBadRequestException(Long id) {
        return clientRepository.findById(id).map(clientMapper::toClientDto)
                .orElseThrow(() -> new BadRequestExceptions("Cliente não encontrado"));
    }

    @Override
    public Client insert(ClientPersistDto clientPersistDto) {

        Client newClient = clientMapper.toClienPersistDto(clientPersistDto);
        Client savedClient = clientRepository.save(newClient);

        for (Address address : savedClient.getAddresses()) {
            address.setClientAddress(savedClient);
        }
        return clientRepository.save(savedClient);
    }

    @Override
    public void update(Long id, ClientPersistDto clientPersistDto) {

        Client client = clientRepository.findById(id).get();

        clientMapper.toClientUpdateDto(client, clientPersistDto);

        for (Address address : client.getAddresses()) {
            address.setClientAddress(client);
        }

        clientRepository.save(client);
    }


    @Override
    public void delete(Long id) {
        Client client = clientRepository.findById(id).get();
        clientRepository.deleteById(client.getId());
    }
}
