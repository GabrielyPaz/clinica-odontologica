package br.com.clinicaodontologica.clinica.domain.service.impl;

import br.com.clinicaodontologica.clinica.domain.entity.Paciente;
import br.com.clinicaodontologica.clinica.domain.repository.PacienteRepository;
import br.com.clinicaodontologica.clinica.domain.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service

public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public Paciente criarPaciente(Paciente paciente) {
        return null;
    }

    @Override
    public Paciente atualizarPaciente(UUID id, Paciente paciente) {
        return null;
    }

    @Override
    public List<Paciente> buscarPaciente(String nome) {
        return null;
    }

    @Override
    public Paciente buscarPacientePorId(UUID id) {
        return null;
    }

    @Override
    public void deletarPaciente(UUID id) {

    }
}
