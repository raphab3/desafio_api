package br.com.backend.desafio_api.modules.clients.infra.controllers;

import br.com.backend.desafio_api.modules.clients.entities.Client;
import br.com.backend.desafio_api.modules.clients.infra.dtos.ClientDto;
import br.com.backend.desafio_api.modules.clients.infra.dtos.ClientPersistDto;
import br.com.backend.desafio_api.modules.clients.services.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/clients")
@CrossOrigin("*")
@Log4j2
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Client add(@RequestBody ClientPersistDto clientPersistDto) {
        return clientService.insert(clientPersistDto);
    }

    @GetMapping()
    public ResponseEntity<List<Client>> findAll() {
        return clientService.findAll();
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<Client>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "24") Integer size,
            @RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
            @RequestParam(value = "direction", defaultValue = "DESC") String direction) {
        Page<Client> list = clientService.findPage(page, size,  direction, orderBy);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ClientDto> findById(@PathVariable Long id) {
        try {
            ClientDto client = clientService.findByIdOrThrowBadRequestException(id);
            return ResponseEntity.ok().body(client);
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void replace(@PathVariable Long id, @RequestBody ClientPersistDto clientPersistDto) {
        clientService.update(id, clientPersistDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        clientService.delete(id);
    }

}
