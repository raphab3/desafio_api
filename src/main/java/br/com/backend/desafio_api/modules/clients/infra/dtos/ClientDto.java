package br.com.backend.desafio_api.modules.clients.infra.dtos;


import lombok.Data;

import java.util.Date;

@Data
public class ClientDto {
    private final Long id;
    private final String name;
    private final String cpf;
    private final String birthDate;
}
