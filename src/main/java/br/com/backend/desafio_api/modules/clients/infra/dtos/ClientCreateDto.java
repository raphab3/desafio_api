package br.com.backend.desafio_api.modules.clients.infra.dtos;

import br.com.backend.desafio_api.modules.clients.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientCreateDto {
    private final String name;
    private final String cpf;
    private final String birthDate;


    public ClientCreateDto(ClientCreateDto entity) {
        this.name = entity.getName();
        this.cpf = entity.getCpf();
        this.birthDate = entity.getBirthDate();
    }

}
