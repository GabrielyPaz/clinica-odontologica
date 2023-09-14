package br.com.clinicaodontologica.clinica.domain.service;

import br.com.clinicaodontologica.clinica.domain.entity.Contato;

import java.util.List;
import java.util.UUID;

public interface ContatoService {

    Contato criarContato(Contato contato);
    List<Contato> buscarContatos();
    Contato buscarContatoPorId(UUID id);
    Contato atualizarContato(Contato contato);
    void deletarContato(UUID id);
}
