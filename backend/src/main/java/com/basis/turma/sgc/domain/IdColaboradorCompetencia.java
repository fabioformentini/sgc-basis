package com.basis.turma.sgc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "colaborador_competencia")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
//Embeddable representa uma chave primaria composta
public class IdColaboradorCompetencia implements Serializable {

    @Column(name="id_colaborador")
    private Long id_colaborador;
    @Column(name="id_competencia")
    private Long id_competencia;

}

