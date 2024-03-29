package br.com.backend.desafio_api.modules.orders.infra.dtos;


import br.com.backend.desafio_api.modules.clients.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private Double amount;
    private LocalDateTime createdAt;
    private final Client clientOrder;
}
