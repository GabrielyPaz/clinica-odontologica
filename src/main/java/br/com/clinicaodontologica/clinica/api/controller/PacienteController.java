package br.com.clinicaodontologica.clinica.api.controller;

import br.com.clinicaodontologica.clinica.api.dto.request.PacienteRequest;
import br.com.clinicaodontologica.clinica.api.dto.response.PacienteResponse;
import br.com.clinicaodontologica.clinica.domain.entity.Paciente;
import br.com.clinicaodontologica.clinica.domain.service.PacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;
    private final ObjectMapper objectMapper;

    @Autowired
    public PacienteController(PacienteService pacienteService, ObjectMapper objectMapper) {
        this.pacienteService = pacienteService;
        this.objectMapper = objectMapper;
    }


    @PostMapping
    public ResponseEntity<?> criarPaciente (@RequestBody @Valid PacienteRequest request){
        Paciente paciente = objectMapper.convertValue(request, Paciente.class);
        Paciente paciente1 = pacienteService.criarPaciente(paciente);
        PacienteResponse response = objectMapper.convertValue(paciente1, PacienteResponse.class);
        return ResponseEntity.ok(response);
    }

}
