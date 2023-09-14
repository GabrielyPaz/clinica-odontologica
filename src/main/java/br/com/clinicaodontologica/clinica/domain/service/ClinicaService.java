package br.com.clinicaodontologica.clinica.domain.service;

import br.com.clinicaodontologica.clinica.domain.entity.Clinica;

import java.util.List;
import java.util.UUID;

public interface ClinicaService {

    Clinica criarClinica (Clinica clinica);
    Clinica atualizarClinica (Clinica clinica);
    List<Clinica> buscarClinicas(String nome);
    Clinica buscarClinicaPorId (UUID id);
    void deletarClinica (UUID id);

}
