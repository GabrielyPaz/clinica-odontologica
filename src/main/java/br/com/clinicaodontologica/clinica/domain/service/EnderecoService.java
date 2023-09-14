package br.com.clinicaodontologica.clinica.domain.service;

import br.com.clinicaodontologica.clinica.domain.entity.Endereco;

import java.util.List;
import java.util.UUID;

public interface EnderecoService {

    Endereco criarEndereco(Endereco endereco);
    List<Endereco> buscarEnderecos();
    Endereco buscarEnderecoPorId(UUID id);
    Endereco atualizarEndereco(Endereco endereco);
    void deletarEndereco(UUID id);
}
