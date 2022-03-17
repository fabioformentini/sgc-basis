package com.basis.turma.sgc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "colaborador_competencia")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ColaboradorCompetencia implements Serializable {

    @EmbeddedId
    private IdColaboradorCompetencia id;

    @ManyToOne
    @MapsId("id_colaborador")
    @JoinColumn(name = "id_colaborador", referencedColumnName = "id")
    private Colaborador colaborador;

    @ManyToOne
    @MapsId("id_competencia")
    @JoinColumn(name = "id_competencia", referencedColumnName = "id")
    private Competencia competencia;

    @Column(name = "nivel")
    private Integer nivel;



}
