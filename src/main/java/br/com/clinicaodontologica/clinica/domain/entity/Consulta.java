package br.com.clinicaodontologica.clinica.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Table(name= "consultas")
@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name="paciente_id", foreignKey = @ForeignKey(name="fk_consulta_paciente"))
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name="dentista_id", foreignKey = @ForeignKey(name="fk_consulta_dentista"))
    private Dentista dentista;

    @ManyToOne
    @JoinColumn(name="clinica_id", foreignKey = @ForeignKey(name="fk_consulta_clinica"))
    private Clinica clinica;

    private LocalDateTime dataConsulta;
    @Column(updatable = false)
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
    private String descricao;
    private Boolean cancelada;
    @Column(length = 80)
    private String motivoCancelamento;

    @PrePersist
    public void naCriacao(){
        this.criadoEm = LocalDateTime.now();
    }

    @PreUpdate
    public void naAtualizacao(){
        this.atualizadoEm = LocalDateTime.now();
    }

}
