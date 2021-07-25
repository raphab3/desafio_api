package br.com.backend.desafio_api.modules.orders.repositories;

import br.com.backend.desafio_api.modules.orders.entities.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OrderRepository {

    private Map<Long, Order> map = new HashMap<>();

    public void save(Order obj) {
        map.put(obj.getId(), obj);
    }

    public Order findById(Long id) {
        return map.get(id);
    }

    public List<Order> findAll() {
        return new ArrayList<Order>(map.values());
    }
}
