package br.com.clinicaodontologica.clinica.domain.exception;

public class CnpjAlreadyExistsException extends RuntimeException{
    public CnpjAlreadyExistsException(String cnpj) {
        super("Cnpj já encontrado " + cnpj);
    }
}
