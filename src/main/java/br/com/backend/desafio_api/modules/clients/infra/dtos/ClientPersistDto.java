package br.com.backend.desafio_api.modules.clients.infra.dtos;

import br.com.backend.desafio_api.modules.addresses.infra.dtos.AddressCreateDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ClientPersistDto {
    private String name;
    private String cpf;
    private String birthDate;
    private final List<AddressCreateDto> addresses;
}
