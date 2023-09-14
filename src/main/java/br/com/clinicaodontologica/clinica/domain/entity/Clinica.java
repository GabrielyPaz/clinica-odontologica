package br.com.clinicaodontologica.clinica.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.br.CNPJ;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@ToString
@Table(name= "clinicas")
@Entity

public class Clinica {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToMany
    @JoinTable(
            name = "clinicaDentistas",
            joinColumns = @JoinColumn(name = "id_dentista"),
            inverseJoinColumns = @JoinColumn(name = "id_clinica"),
            foreignKey =
            @ForeignKey(name = "fk_clinica_dentista"))
    private Set<Dentista> clinicaDentista;
    private String nome;
    @Column(length = 20)
    private String cnpj;
    private String razaoSocial;
    @Column(updatable = false)
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
    private String descricao;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco",
                referencedColumnName = "id",
                foreignKey = @ForeignKey(name = "fk_clinica_endereco"))
    private Endereco endereco;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contato",
                referencedColumnName = "id",
                foreignKey = @ForeignKey(name = "fk_clinica_contato"))
    private Contato contato;
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_clinica")
//    private Set<Consulta> consultas;

    @PrePersist
    public void naCriacao(){
        this.criadoEm = LocalDateTime.now();
    }

    @PreUpdate
    public void naAtualizacao(){
        this.atualizadoEm = LocalDateTime.now();
    }

}
