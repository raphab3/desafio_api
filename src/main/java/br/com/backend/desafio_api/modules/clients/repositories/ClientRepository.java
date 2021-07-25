package br.com.backend.desafio_api.modules.clients.repositories;

import br.com.backend.desafio_api.modules.clients.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
