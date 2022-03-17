package com.basis.turma.sgc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="turma_formacao")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TurmaFormacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencia_turma_formacao")
    @SequenceGenerator(name="sequencia_turma_formacao", sequenceName = "sequencia_turma_formacao",
    allocationSize = 1)
    @Column(name="id")
    private Long id;
    @Column(name="nome")
    private String nome;
    @Column(name="descricao")
    private String descricao;
    @Column(name="data_inicio")
    private LocalDate dataInicio;
    @Column(name="data_termino")
    private LocalDate dataTermino;
    @ManyToOne
    @JoinColumn(name="id_status", referencedColumnName = "id")
    private Status status;
    @OneToMany(mappedBy = "turmaFormacao", fetch = FetchType.EAGER)
    private List<TurmaFormacaoCompetenciaColaborador> competenciasColaboradores;

}
