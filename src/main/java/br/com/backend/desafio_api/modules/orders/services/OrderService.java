package br.com.backend.desafio_api.modules.orders.services;

import br.com.backend.desafio_api.modules.clients.entities.Client;
import br.com.backend.desafio_api.modules.clients.repositories.ClientRepository;
import br.com.backend.desafio_api.modules.orders.entities.Order;
import br.com.backend.desafio_api.modules.orders.infra.dtos.OrderDto;
import br.com.backend.desafio_api.modules.orders.infra.dtos.OrderPersistDto;
import br.com.backend.desafio_api.modules.orders.infra.dtos.OrderUpdateDto;
import br.com.backend.desafio_api.modules.orders.infra.mapper.OrderMapper;
import br.com.backend.desafio_api.modules.orders.repositories.OrderRepository;
import br.com.backend.desafio_api.shared.exceptions.BadRequestExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService implements IOrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Page<Order> findPage(Integer page, Integer size, String direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.valueOf(direction), orderBy);
        return orderRepository.findAll(pageRequest);
    }

    @Override
    public OrderDto findByIdOrThrowBadRequestException(Long id) {
        return orderRepository.findById(id).map(orderMapper::toOrdertDto)
                .orElseThrow(() -> new BadRequestExceptions("Cliente não encontrado"));
    }

    @Override
    public Order insert(OrderPersistDto orderPersistDto) {
        Order newOrder = orderMapper.toCreateOrder(orderPersistDto);
        Optional<Client> client = Optional.of(clientRepository.findById(orderPersistDto.getClientId()).get());
        Order savedOrder = orderRepository.save(newOrder);
        savedOrder.setClientOrder(client.get());
        return orderRepository.save(savedOrder);
    }

    @Override
    public void update(Long id, OrderUpdateDto orderUpdateDto) {
        Order order = orderRepository.findById(id).get();
        orderMapper.toOrderUpdateDto(order, orderUpdateDto);
        orderRepository.save(order);
    }


    @Override
    public void delete(Long id) {
        Order order = orderRepository.findById(id).get();
        orderRepository.deleteById(order.getId());
    }
}
