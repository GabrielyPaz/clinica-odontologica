package br.com.clinicaodontologica.clinica.api.controller;

import br.com.clinicaodontologica.clinica.api.dto.request.PacienteRequest;
import br.com.clinicaodontologica.clinica.api.dto.response.PacienteResponse;
import br.com.clinicaodontologica.clinica.api.dto.response.listResponse.PacienteListResponse;
import br.com.clinicaodontologica.clinica.api.dto.response.wrapperResponse.PacienteWrapperResponse;
import br.com.clinicaodontologica.clinica.domain.entity.Paciente;
import br.com.clinicaodontologica.clinica.domain.service.PacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
     ResponseEntity<?> criarPaciente (@RequestBody @Valid PacienteRequest request){
        Paciente paciente = objectMapper.convertValue(request, Paciente.class);
        Paciente paciente1 = pacienteService.criarPaciente(paciente);
        PacienteResponse response = objectMapper.convertValue(paciente1, PacienteResponse.class);
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    ResponseEntity<?>atualizarPaciente (@PathVariable UUID id, @RequestBody @Valid PacienteRequest request){
        Paciente paciente = objectMapper.convertValue(request, Paciente.class);
        Paciente pacienteAtualizado = pacienteService.atualizarPaciente(id,paciente);
        PacienteResponse response = objectMapper.convertValue(pacienteAtualizado, PacienteResponse.class);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    ResponseEntity<PacienteWrapperResponse> buscarPacientesPorNome (@RequestParam(required = false) String nome){
        List<Paciente> pacientes = pacienteService.buscarPaciente(nome);
        PacienteWrapperResponse pacienteWrapperResponse = new PacienteWrapperResponse();
        pacienteWrapperResponse.setPacientes(pacientes.stream().map(paciente -> {
            PacienteListResponse pacienteListResponse = new PacienteListResponse();
            pacienteListResponse.setId(paciente.getId());
            pacienteListResponse.setNome(paciente.getNome());
            return pacienteListResponse;
        }).toList());

        return ResponseEntity.ok(pacienteWrapperResponse);
    }

    @GetMapping("{id}")
    ResponseEntity<PacienteResponse> buscarPorId (@PathVariable UUID id){
    Paciente paciente = pacienteService.buscarPacientePorId(id);
    PacienteResponse response = pacienteResponseByPaciente(paciente);
    return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void>deleteClinica (@PathVariable UUID id){
        pacienteService.deletarPaciente(id);
        return ResponseEntity.ok().build();
    }

    private PacienteResponse pacienteResponseByPaciente (Paciente paciente){
        return objectMapper.convertValue(paciente, PacienteResponse.class);
    }

}
