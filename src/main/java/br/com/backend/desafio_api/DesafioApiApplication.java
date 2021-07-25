package br.com.backend.desafio_api;

import br.com.backend.desafio_api.modules.clients.entities.Client;
import br.com.backend.desafio_api.modules.clients.infra.dtos.ClientDto;
import br.com.backend.desafio_api.modules.clients.repositories.ClientRepository;
import br.com.backend.desafio_api.modules.orders.entities.Order;
import br.com.backend.desafio_api.modules.orders.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DesafioApiApplication  {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OrderRepository orderRepository;

    public static void main(String[] args) {
        SpringApplication.run(DesafioApiApplication.class, args);
    }
}
