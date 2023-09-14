package br.com.clinicaodontologica.clinica.api.dto.request;

import br.com.clinicaodontologica.clinica.domain.entity.Consulta;
import br.com.clinicaodontologica.clinica.domain.entity.Dentista;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
public class ClinicaRequest {

    @NotBlank
    private String nome;
    @CNPJ
    @NotBlank
    private String cnpj;
    @NotBlank
    @Length(min = 5, max = 255)
    @JsonAlias(value = "razao_social")
    private String razaoSocial;
    @NotBlank
    private String descricao;
    @Valid
    @NotNull
    private EnderecoRequest endereco;
    @Valid
    @NotNull
    private ContatoRequest contato;

}
