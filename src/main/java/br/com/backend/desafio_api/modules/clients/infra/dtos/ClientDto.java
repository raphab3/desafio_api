package br.com.backend.desafio_api.modules.clients.infra.dtos;

import br.com.backend.desafio_api.modules.clients.entities.Client;
import lombok.Data;

@Data
public class ClientDto {
    private final Long id;
    private final String name;
    private final String cpf;
    private final String birthDate;

    public ClientDto(Client entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.cpf = entity.getCpf();
        this.birthDate = entity.getBirthDate();
    }
}
