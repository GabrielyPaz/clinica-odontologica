package br.com.clinicaodontologica.clinica.api.dto.response;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoResponse {

    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
}
