package br.com.backend.desafio_api.modules.orders.infra.dtos;


import lombok.Data;

@Data
public class OrderDto {
    private Long id;
    private Double amount;
//    private Date dateOrder;
//    private Client clientOrder;
}
