package br.com.clinicaodontologica.clinica.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name= "contatos")

public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @Column(length = 100)
    @Email
    private String email;
    @Column(length = 15)
    private String telefone;
    @Column(updatable = false)
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    @PrePersist
    public void naCriacao(){
        this.criadoEm = LocalDateTime.now();
    }

    @PreUpdate
    public void naAtualizacao(){
        this.atualizadoEm = LocalDateTime.now();
    }
}
