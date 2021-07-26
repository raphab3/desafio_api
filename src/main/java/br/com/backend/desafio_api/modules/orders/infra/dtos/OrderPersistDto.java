package br.com.backend.desafio_api.modules.orders.infra.dtos;

import br.com.backend.desafio_api.modules.clients.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class OrderPersistDto {
    private final Double amount;
    private final Long clientId;
}
