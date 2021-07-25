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
public class DesafioApiApplication implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OrderRepository orderRepository;

    public static void main(String[] args) {
        SpringApplication.run(DesafioApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        Client cli1 = new Client(1L, "Rafa", "08420698440", "16/03/1991");
        Client cli2 = new Client(2L, "Rafa2", "08420698440", "16/03/1991");


        Order or1 = new Order(1L, 60.0, cli1);
        Order or2 = new Order(2L, 70.0, cli1);
        Order or3 = new Order(3L, 35.0, cli2);
        Order or4 = new Order(4L, 640.0, cli2);


        clientRepository.save(cli1);
        clientRepository.save(cli2);

        orderRepository.save(or1);
        orderRepository.save(or2);
        orderRepository.save(or3);
        orderRepository.save(or4);

    }
}
