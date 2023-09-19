package br.com.clinicaodontologica.clinica.api.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class ConsultaResponse {

    private UUID id;
    private LocalDateTime dataConsulta;
}

