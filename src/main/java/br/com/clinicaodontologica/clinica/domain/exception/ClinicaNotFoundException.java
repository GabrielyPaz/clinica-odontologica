package br.com.clinicaodontologica.clinica.domain.exception;

import java.util.UUID;

public class ClinicaNotFoundException extends RuntimeException {
    public ClinicaNotFoundException(UUID id){
        super("Id da clinica não encontrado " + id);
    }
}
