package br.com.backend.desafio_api.modules.addresses.infra.dtos;

import br.com.backend.desafio_api.modules.clients.entities.Client;
import lombok.Data;

@Data
public class AddressCreateDto {
    private final String street;
    private final String district;
    private final String city;
    private final String uf;
    private final String number;
    private final String zipCode;
    private final String complement;
    private final Client client;
}
