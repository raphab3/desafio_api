package br.com.backend.desafio_api.modules.clients.infra.controllers;

import br.com.backend.desafio_api.modules.clients.entities.Client;
import br.com.backend.desafio_api.modules.clients.infra.dtos.ClientCreateDto;
import br.com.backend.desafio_api.modules.clients.infra.dtos.ClientDto;
import br.com.backend.desafio_api.modules.clients.services.ClientService;
import br.com.backend.desafio_api.modules.clients.services.exceptions.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "clients")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Client> add(@RequestBody ClientCreateDto obj) {
        Client client = clientService.insert(obj);
        return ResponseEntity.ok().body(client);
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> findAll() {
        List<ClientDto> list = clientService.findAll();
        return ResponseEntity.ok().body(list);
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
            ClientDto client = clientService.findById(id);
            return ResponseEntity.ok().body(client);
        } catch (ServiceException e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, @RequestBody Client clientDto) {
        clientService.update(id, clientDto);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        clientService.delete(id);
    }

}
