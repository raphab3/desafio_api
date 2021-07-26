package br.com.backend.desafio_api.modules.orders.infra.controllers;

import br.com.backend.desafio_api.modules.orders.entities.Order;
import br.com.backend.desafio_api.modules.orders.infra.dtos.OrderDto;
import br.com.backend.desafio_api.modules.orders.infra.dtos.OrderPersistDto;
import br.com.backend.desafio_api.modules.orders.infra.dtos.OrderUpdateDto;
import br.com.backend.desafio_api.modules.orders.services.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/orders")
@CrossOrigin("*")
@Log4j2
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Order add(@RequestBody OrderPersistDto orderPersistDto) {
        log.info(orderPersistDto);
        return orderService.insert(orderPersistDto);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<Order>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "24") Integer size,
            @RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
            @RequestParam(value = "direction", defaultValue = "DESC") String direction) {
        Page<Order> list = orderService.findPage(page, size, direction, orderBy);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<OrderDto> findById(@PathVariable Long id) {
        try {
            OrderDto orderDto = orderService.findByIdOrThrowBadRequestException(id);
            return ResponseEntity.ok().body(orderDto);
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void replace(@PathVariable Long id, @RequestBody OrderUpdateDto orderUpdateDto) {
        orderService.update(id, orderUpdateDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        orderService.delete(id);
    }
}
