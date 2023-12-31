package br.com.clinicaodontologica.clinica.api.dto.request;

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
import java.util.Set;
import java.util.UUID;

@Getter
@Setter

public class PacienteRequest {

    @NotBlank
    private String nome;
    @NotNull
    private LocalDate dataNascimento;
    @Valid
    @NotNull
    private EnderecoRequest endereco;
    @NotNull
    @JsonAlias(value = "sexo")
    private GeneroEnum genero;
    @Valid
    @NotNull
    private ContatoRequest contato;



}
