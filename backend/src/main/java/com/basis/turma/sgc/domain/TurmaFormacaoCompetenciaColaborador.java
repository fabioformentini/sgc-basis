package com.basis.turma.sgc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "turma_formacao_competencia_colaborador")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TurmaFormacaoCompetenciaColaborador implements Serializable {

    @EmbeddedId
    private IdTurmaFormacaoCompetenciaColaborador id;
    @ManyToOne
    @MapsId("id_turma_formacao")
    @JoinColumn(name = "id_turma_formacao", referencedColumnName = "id")
    private TurmaFormacao turmaFormacao;
    @ManyToOne
    @MapsId("id_competencia")
    @JoinColumn(name = "id_competencia", referencedColumnName = "id")
    private Competencia competencia;
    @ManyToOne
    @MapsId("id_colaborador")
    @JoinColumn(name = "id_colaborador", referencedColumnName = "id")
    private Colaborador colaborador;

}
