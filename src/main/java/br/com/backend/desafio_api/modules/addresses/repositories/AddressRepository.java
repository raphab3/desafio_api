package br.com.backend.desafio_api.modules.addresses.repositories;

import br.com.backend.desafio_api.modules.addresses.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
