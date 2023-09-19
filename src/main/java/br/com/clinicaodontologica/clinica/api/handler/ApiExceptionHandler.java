package br.com.clinicaodontologica.clinica.api.handler;

import br.com.clinicaodontologica.clinica.domain.exception.ClinicaNotFoundException;
import br.com.clinicaodontologica.clinica.domain.exception.CnpjAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(CnpjAlreadyExistsException.class)
    public ResponseEntity<?> cnpjJaExistente
            (CnpjAlreadyExistsException cnpjAlreadyExistsException){
        return ResponseEntity.badRequest().body(cnpjAlreadyExistsException.getMessage());
    }

    @ExceptionHandler(ClinicaNotFoundException.class)
    public ResponseEntity<?> clinicaNaoEncontrada
            (ClinicaNotFoundException clinicaNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(clinicaNotFoundException.getMessage());
    }
}
