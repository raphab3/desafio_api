package br.com.backend.desafio_api;

import br.com.backend.desafio_api.modules.addresses.entities.Address;
import br.com.backend.desafio_api.modules.addresses.repositories.AddressRepository;
import br.com.backend.desafio_api.modules.clients.entities.Client;
import br.com.backend.desafio_api.modules.clients.repositories.ClientRepository;
import br.com.backend.desafio_api.modules.orders.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DesafioApiApplication implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AddressRepository addressRepository;

    public static void main(String[] args) {
        SpringApplication.run(DesafioApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
