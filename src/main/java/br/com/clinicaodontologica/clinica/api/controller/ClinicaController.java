package br.com.clinicaodontologica.clinica.api.controller;

import br.com.clinicaodontologica.clinica.api.dto.request.ClinicaRequest;
import br.com.clinicaodontologica.clinica.api.dto.response.ClinicaResponse;
import br.com.clinicaodontologica.clinica.domain.entity.Clinica;
import br.com.clinicaodontologica.clinica.domain.service.ClinicaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    ResponseEntity<?> criarClinica (@RequestBody @Valid ClinicaRequest request){
        Clinica clinica = objectMapper.convertValue(request,Clinica.class);
        Clinica clinicaCriada = clinicaService.criarClinica(clinica);
        ClinicaResponse response = objectMapper.convertValue(clinicaCriada,ClinicaResponse.class);
        return ResponseEntity.ok(response);
    }

    @PutMapping ("{id}")
    ResponseEntity<?> atualizarClinica (@PathVariable UUID id, @RequestBody @Valid ClinicaRequest request){
        Clinica clinica = objectMapper.convertValue(request,Clinica.class);
        Clinica clinicaAtualizada = clinicaService.atualizarClinica(id, clinica);
        ClinicaResponse response = objectMapper.convertValue(clinicaAtualizada,ClinicaResponse.class);
        return ResponseEntity.ok (response);
    }









}
