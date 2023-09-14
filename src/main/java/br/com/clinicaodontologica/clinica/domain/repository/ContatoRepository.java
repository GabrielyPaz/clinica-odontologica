package br.com.clinicaodontologica.clinica.domain.repository;

import br.com.clinicaodontologica.clinica.domain.entity.Consulta;
import br.com.clinicaodontologica.clinica.domain.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, UUID> {
}
