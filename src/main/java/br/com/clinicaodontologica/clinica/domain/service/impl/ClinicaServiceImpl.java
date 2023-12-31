package br.com.clinicaodontologica.clinica.domain.service.impl;

import br.com.clinicaodontologica.clinica.domain.entity.Clinica;
import br.com.clinicaodontologica.clinica.domain.exception.ClinicaNotFoundException;
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
    public Clinica atualizarClinica(UUID id, Clinica clinica){
        Clinica clinicaAtual = this.clinicaRepository.findById(id).orElseThrow(() -> new ClinicaNotFoundException(id));
        boolean existeClinica = this.clinicaRepository.existsByCnpjAndIdIsNot(clinica.getCnpj(), id);
        if (existeClinica){
            throw new CnpjAlreadyExistsException(clinica.getCnpj());
        }
        clinicaAtual.setNome(clinica.getNome());
        clinicaAtual.setCnpj(clinica.getCnpj());
        clinicaAtual.setRazaoSocial(clinica.getRazaoSocial());
        clinicaAtual.setDescricao(clinica.getDescricao());
        clinicaAtual.setEndereco(clinica.getEndereco());
        clinicaAtual.setContato(clinica.getContato());

        return this.clinicaRepository.save(clinicaAtual);
    }

    @Override
    public List<Clinica> buscarClinicas(String nome) {
        if (nome == null){
            return this.clinicaRepository.findAll();
        }
        return this.clinicaRepository.findByNomeStartingWith(nome);
    }

    @Override
    public Clinica buscarClinicaPorId(UUID id) {
        return this.clinicaRepository
                .findById(id)
                .orElseThrow(() -> new ClinicaNotFoundException(id));
    }

    @Override
    public  void deletarClinica (UUID id){
        Clinica clinica = clinicaRepository
                .findById(id).orElseThrow(() -> new ClinicaNotFoundException(id));
        clinicaRepository.delete(clinica);
    }
}
