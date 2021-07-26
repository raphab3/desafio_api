package br.com.backend.desafio_api.modules.clients.infra.mapper;

import br.com.backend.desafio_api.modules.clients.entities.Client;
import br.com.backend.desafio_api.modules.clients.infra.dtos.ClientDto;
import br.com.backend.desafio_api.modules.clients.infra.dtos.ClientPersistDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    //   de ClientCreateDto  para Client
    Client toClienPersistDto(ClientPersistDto clientPersistDto);

    // de Client para ClientDto
    ClientDto toClientDto(Client client);

    void toClientUpdateDto(@MappingTarget Client client, ClientPersistDto clientPersistDto);

}
