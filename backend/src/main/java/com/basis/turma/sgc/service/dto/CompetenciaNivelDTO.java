package com.basis.turma.sgc.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CompetenciaNivelDTO implements Serializable {

    private Long idCompetencia;
    private String nomeCompetencia;
    private Integer nivel;

}

