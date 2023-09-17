package br.com.clinicaodontologica.clinica.api.dto.response;

import br.com.clinicaodontologica.clinica.api.dto.request.ContatoRequest;
import br.com.clinicaodontologica.clinica.domain.entity.Contato;
import br.com.clinicaodontologica.clinica.domain.entity.Dentista;
import br.com.clinicaodontologica.clinica.domain.entity.Endereco;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;


@Getter
@Setter

public class ClinicaResponse {

    private UUID id;
    private Set<Dentista> clinicaDentista;
    private String nome;
    private String cnpj;
    private String razaoSocial;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
    private String descricao;

    private EnderecoResponse endereco;

    private ContatoResponse contato;

}
