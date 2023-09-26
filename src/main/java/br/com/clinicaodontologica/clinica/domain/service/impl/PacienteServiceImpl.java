package br.com.clinicaodontologica.clinica.domain.service.impl;

import br.com.clinicaodontologica.clinica.api.controller.PacienteController;
import br.com.clinicaodontologica.clinica.domain.entity.Paciente;
import br.com.clinicaodontologica.clinica.domain.exception.PacienteNotFoundException;
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
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente atualizarPaciente(UUID id, Paciente paciente) {
        Paciente pacienteAtual = this.pacienteRepository.findById(id).orElseThrow(() -> new PacienteNotFoundException(id));
        pacienteAtual.setNome(paciente.getNome());
        pacienteAtual.setDataNascimento(paciente.getDataNascimento());
        pacienteAtual.setGenero(paciente.getGenero());
        pacienteAtual.setEndereco(paciente.getEndereco());
        pacienteAtual.setContato(paciente.getContato());

        return this.pacienteRepository.save(pacienteAtual);
    }

    @Override
    public List<Paciente> buscarPaciente(String nome) {
        if (nome== null){
            return this.pacienteRepository.findAll();
        }
        return this.pacienteRepository.findByNomeStartingWith(nome);
    }

    @Override
    public Paciente buscarPacientePorId(UUID id) {
        return this.pacienteRepository
                .findById(id)
                .orElseThrow(() -> new PacienteNotFoundException(id));
    }

    @Override
    public void deletarPaciente(UUID id) {
        Paciente paciente = pacienteRepository
                .findById(id)
                .orElseThrow(() -> new PacienteNotFoundException(id));
        pacienteRepository.delete(paciente);
    }
}
