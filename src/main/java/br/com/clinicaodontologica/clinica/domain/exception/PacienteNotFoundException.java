package br.com.clinicaodontologica.clinica.domain.exception;

import java.util.UUID;

public class PacienteNotFoundException extends RuntimeException{

    public PacienteNotFoundException(UUID id){
        super("Id do Paciente não encontrado " + id);
    }
}
