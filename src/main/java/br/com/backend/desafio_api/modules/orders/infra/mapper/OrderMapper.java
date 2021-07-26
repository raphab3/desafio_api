package br.com.backend.desafio_api.modules.orders.infra.mapper;

import br.com.backend.desafio_api.modules.clients.entities.Client;
import br.com.backend.desafio_api.modules.clients.infra.dtos.ClientDto;
import br.com.backend.desafio_api.modules.clients.infra.dtos.ClientPersistDto;
import br.com.backend.desafio_api.modules.orders.entities.Order;
import br.com.backend.desafio_api.modules.orders.infra.dtos.OrderDto;
import br.com.backend.desafio_api.modules.orders.infra.dtos.OrderPersistDto;
import br.com.backend.desafio_api.modules.orders.infra.dtos.OrderUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toCreateOrder(OrderPersistDto orderPersistDtoDto);

    OrderDto toOrdertDto(Order order);

    Client toClient(ClientDto clientDto);

    void toOrderUpdateDto(@MappingTarget Order order, OrderUpdateDto orderUpdateDto);
}
