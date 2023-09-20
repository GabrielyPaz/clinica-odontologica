package br.com.clinicaodontologica.clinica.api.controller;

import br.com.clinicaodontologica.clinica.api.dto.request.ClinicaRequest;
import br.com.clinicaodontologica.clinica.api.dto.response.ClinicaResponse;
import br.com.clinicaodontologica.clinica.api.dto.response.listResponse.ClinicaListResponse;
import br.com.clinicaodontologica.clinica.api.dto.response.wrapperResponse.ClinicaWrapperResponse;
import br.com.clinicaodontologica.clinica.domain.entity.Clinica;
import br.com.clinicaodontologica.clinica.domain.service.ClinicaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/clinicas")
public class ClinicaController {
    private final ClinicaService clinicaService;
    private final ObjectMapper objectMapper;


    @Autowired
    public ClinicaController(ClinicaService clinicaService, ObjectMapper objectMapper) {
        this.clinicaService = clinicaService;
        this.objectMapper = objectMapper;
    }

    @PostMapping
    ResponseEntity<?> criarClinica(@RequestBody @Valid ClinicaRequest request) {
        Clinica clinica = objectMapper.convertValue(request, Clinica.class);
        Clinica clinicaCriada = clinicaService.criarClinica(clinica);
        ClinicaResponse response = objectMapper.convertValue(clinicaCriada, ClinicaResponse.class);
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    ResponseEntity<?> atualizarClinica(@PathVariable UUID id, @RequestBody @Valid ClinicaRequest request) {
        Clinica clinica = objectMapper.convertValue(request, Clinica.class);
        Clinica clinicaAtualizada = clinicaService.atualizarClinica(id, clinica);
        ClinicaResponse response = objectMapper.convertValue(clinicaAtualizada, ClinicaResponse.class);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    ResponseEntity<ClinicaWrapperResponse> buscarClinicasPorNome(@RequestParam(required = false) String nome) {
        List<Clinica> clinicas = clinicaService.buscarClinicas(nome);
        ClinicaWrapperResponse clinicaWrapperResponse = new ClinicaWrapperResponse();
        clinicaWrapperResponse.setClinicas(clinicas.stream().map(clinica -> {
            ClinicaListResponse clinicaListResponse = new ClinicaListResponse();
            clinicaListResponse.setId(clinica.getId());
            clinicaListResponse.setNome(clinica.getNome());
            clinicaListResponse.setCnpj(clinica.getCnpj());
            return clinicaListResponse;
        }).toList());

        return ResponseEntity.ok(clinicaWrapperResponse);
    }

    @GetMapping("{id}")
    ResponseEntity<ClinicaResponse>buscarPorId(@PathVariable UUID id) {
    Clinica clinica = clinicaService.buscarClinicaPorId(id);
    ClinicaResponse response = clinicaResponseByClinica(clinica);
    return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void>deletarClinica(@PathVariable UUID id){
        clinicaService.deletarClinica(id);
        return ResponseEntity.ok().build();
    }

    private ClinicaResponse clinicaResponseByClinica(Clinica clinica) {
        return objectMapper.convertValue(clinica, ClinicaResponse.class);
    }


}
