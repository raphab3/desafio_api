package br.com.backend.desafio_api.modules.clients.repositories;

import br.com.backend.desafio_api.modules.clients.entities.Client;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ClientRepository {

    private Map<Long, Client> map = new HashMap<>();

    public void save(Client obj) {
        map.put(obj.getId(), obj);
    }

    public Client findById(Long id) {
        return map.get(id);
    }

    public List<Client> findAll() {
        return new ArrayList<Client>(map.values());
    }

}
