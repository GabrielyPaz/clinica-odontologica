package br.com.clinicaodontologica.clinica.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name= "enderecos")

public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @Column(length = 100)
    private String logradouro;
    @Column(length = 100)
    private String bairro;
    @Column(updatable = false)
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
    @Column(length = 100)
    private String cidade;
    @Column(length = 100)
    private String estado;
    private String cep;
    @PrePersist
    public void naCriacao(){
        this.criadoEm = LocalDateTime.now();
    }
    @PreUpdate
    public void naAtualizacao(){
        this.atualizadoEm = LocalDateTime.now();
    }

}
