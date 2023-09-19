package br.com.clinicaodontologica.clinica.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@ToString
@Table(name= "pacientes")
@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id")
    private UUID id;
    private String nome;
    private LocalDate dataNascimento;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_paciente_endereco"))
    private Endereco endereco;
    @Column(updatable = false)
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
    @Column(length = 1)
    private GeneroEnum genero;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contato",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_paciente_contato"))
    private Contato contato;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_paciente")
    private Set<Consulta> consultas;

    @PrePersist
    public void naCriacao(){
        this.criadoEm = LocalDateTime.now();
    }

    @PreUpdate
    public void naAtualizacao(){
        this.atualizadoEm = LocalDateTime.now();
    }
}
