package br.com.backend.desafio_api;

import br.com.backend.desafio_api.modules.clients.entities.Client;
import br.com.backend.desafio_api.modules.clients.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioApiApplication  implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;

	public static void main(String[] args) {
		SpringApplication.run(DesafioApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Client cli1 = new Client(1L, "Rafa", "08420698440", "16/03/1991");
		Client cli2 = new Client(2L, "Rafa2", "08420698440", "16/03/1991");
		clientRepository.save(cli1);
		clientRepository.save(cli2);
	}
}
