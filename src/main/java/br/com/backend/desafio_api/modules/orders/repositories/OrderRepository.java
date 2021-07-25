package br.com.backend.desafio_api.modules.orders.repositories;

import br.com.backend.desafio_api.modules.orders.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
