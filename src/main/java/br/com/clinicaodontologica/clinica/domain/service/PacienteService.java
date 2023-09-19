package br.com.clinicaodontologica.clinica.domain.service;

import br.com.clinicaodontologica.clinica.domain.entity.Clinica;
import br.com.clinicaodontologica.clinica.domain.entity.Paciente;

import java.util.List;
import java.util.UUID;

public interface PacienteService {

    Paciente criarPaciente (Paciente paciente);
    Paciente atualizarPaciente (UUID id, Paciente paciente);
    List<Paciente> buscarPaciente(String nome);
    Paciente buscarPacientePorId (UUID id);
    void deletarPaciente (UUID id);
}
