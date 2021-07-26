package br.com.backend.desafio_api.modules.orders.services;

import br.com.backend.desafio_api.modules.orders.entities.Order;
import br.com.backend.desafio_api.modules.orders.infra.dtos.OrderDto;
import br.com.backend.desafio_api.modules.orders.infra.dtos.OrderPersistDto;
import br.com.backend.desafio_api.modules.orders.infra.dtos.OrderUpdateDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IOrderService {

    List<Order> findAll();

    Page<Order> findPage(Integer page, Integer size, String direction, String orderBy);

    OrderDto findByIdOrThrowBadRequestException(Long id);

    Order insert(OrderPersistDto orderPersistDto);

    void update(Long id, OrderUpdateDto orderUpdateDto);

    void delete(Long id);

}
