package br.com.clinicaodontologica.clinica.api.dto.response;

import br.com.clinicaodontologica.clinica.api.dto.request.ContatoRequest;
import br.com.clinicaodontologica.clinica.api.dto.request.EnderecoRequest;
import br.com.clinicaodontologica.clinica.domain.entity.Consulta;
import br.com.clinicaodontologica.clinica.domain.entity.Contato;
import br.com.clinicaodontologica.clinica.domain.entity.Endereco;
import br.com.clinicaodontologica.clinica.domain.entity.GeneroEnum;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter

public class PacienteResponse {

    private UUID id;
    private String nome;
    private LocalDate dataNascimento;
    private Endereco endereco;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
    private GeneroEnum genero;
    private ContatoResponse contato;
    private Set<Consulta> consultas;

}
