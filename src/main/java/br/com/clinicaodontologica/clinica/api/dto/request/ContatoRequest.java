package br.com.clinicaodontologica.clinica.api.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class ContatoRequest {

    @Email
    private String email;
    @Pattern(regexp = "\\((\\d{2})\\) (\\d{4,5})-(\\d{4})")
    //regex validando campos do telefone de acordo com solicitado
    private String telefone;
}
