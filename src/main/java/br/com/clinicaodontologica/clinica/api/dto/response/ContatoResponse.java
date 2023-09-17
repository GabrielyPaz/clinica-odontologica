package br.com.clinicaodontologica.clinica.api.dto.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContatoResponse {

    private String email;
    private String telefone;
}
