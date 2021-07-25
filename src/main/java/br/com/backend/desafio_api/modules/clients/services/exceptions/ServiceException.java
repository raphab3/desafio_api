package br.com.backend.desafio_api.modules.clients.services.exceptions;

import org.springframework.http.ResponseEntity;

public class ServiceException extends RuntimeException {

    private static final long seriaVersionUID = 1L;

    public ServiceException(String msg){
        super(msg);
    }

}
