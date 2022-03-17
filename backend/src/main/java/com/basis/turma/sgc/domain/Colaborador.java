package com.basis.turma.sgc.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "colaborador")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Colaborador implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencia_colaborador")
    @SequenceGenerator(name = "sequencia_colaborador", sequenceName = "sequencia_colaborador", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "sobrenome", nullable = false)
    private String sobrenome;
    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "foto")
    private String foto;
    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;
    @Column(name = "data_admissao", nullable = false)
    private LocalDate dataAdmissao;

    @ManyToOne
    @JoinColumn(name = "id_senioridade", referencedColumnName = "id")
    private Senioridade senioridade;

    @OneToMany(mappedBy = "colaborador", fetch = FetchType.EAGER)
    private List<ColaboradorCompetencia> competenciasList;


}