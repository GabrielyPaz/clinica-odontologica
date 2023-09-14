package br.com.clinicaodontologica.clinica.domain.repository;

import br.com.clinicaodontologica.clinica.domain.entity.Clinica;
import br.com.clinicaodontologica.clinica.domain.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClinicaRepository extends JpaRepository<Clinica, UUID> {
    boolean existsByCnpj(String cnpj);

}
