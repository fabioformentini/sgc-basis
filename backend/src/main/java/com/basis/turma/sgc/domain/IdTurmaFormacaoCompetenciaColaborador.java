package com.basis.turma.sgc.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "turma_formacao_competencia_colaborador")
@NoArgsConstructor
@Data
@Embeddable
public class IdTurmaFormacaoCompetenciaColaborador implements Serializable{

    @Column(name = "id_turma_formacao")
    private Long id_turma_formacao;
    @Column(name = "id_competencia")
    private Long id_competencia;
    @Column(name = "id_colaborador")
    private Long id_colaborador;

}
