package br.com.clinicaodontologica.clinica.domain.service.impl;

import br.com.clinicaodontologica.clinica.domain.entity.Clinica;
import br.com.clinicaodontologica.clinica.domain.exception.CnpjAlreadyExistsException;
import br.com.clinicaodontologica.clinica.domain.repository.ClinicaRepository;
import br.com.clinicaodontologica.clinica.domain.service.ClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClinicaServiceImpl implements ClinicaService {

    private final ClinicaRepository clinicaRepository;

    @Autowired
    public ClinicaServiceImpl(ClinicaRepository clinicaRepository) {
        this.clinicaRepository = clinicaRepository;
    }

    @Override
    public Clinica criarClinica(Clinica clinica) {
        boolean clinicaExiste = this.clinicaRepository.existsByCnpj(clinica.getCnpj());
        if (clinicaExiste){
            throw new CnpjAlreadyExistsException(clinica.getCnpj());
        }
        return this.clinicaRepository.save(clinica);
    }

    @Override
    public Clinica atualizarClinica(Clinica clinica){
        return this.clinicaRepository.save(clinica);
    }

    @Override
    public List<Clinica> buscarClinicas(String nome) {
        return this.clinicaRepository.findAll();
    }

    @Override
    public Clinica buscarClinicaPorId(UUID id) {
        return this.clinicaRepository
                .findById(id)
                .orElseThrow();
    }

    @Override
    public  void deletarClinica (UUID id){
        clinicaRepository.deleteById(id);
    }
}