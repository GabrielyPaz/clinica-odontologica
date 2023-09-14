package br.com.clinicaodontologica.clinica.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name= "dentistas")
public class Dentista {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    private  String nome;
    private LocalDateTime dataNascimento;
    @Column(length = 80)
    private EspecialidadeEnum especialidadeEnum;
    @Column(updatable = false)
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
    @Column(length = 1)
    private GeneroEnum genero;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contato",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_dentista_contato"))
    private Contato contato;
    @ManyToMany
    @JoinTable(
            name = "clinicaDentista",
            joinColumns = @JoinColumn(name = "id_dentista"),
            inverseJoinColumns = @JoinColumn(name = "id_clinica"),
            foreignKey = @ForeignKey(name="fk_dentista_clinica")
            )

    private Set<Clinica> clinicaDentista;

    @PrePersist
    public void naCriacao(){
        this.criadoEm = LocalDateTime.now();
    }

    @PreUpdate
    public void naAtualizacao(){
        this.atualizadoEm = LocalDateTime.now();
    }
}
