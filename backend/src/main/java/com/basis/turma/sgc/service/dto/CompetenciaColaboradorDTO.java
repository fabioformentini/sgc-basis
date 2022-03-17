package com.basis.turma.sgc.service.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CompetenciaColaboradorDTO implements Serializable {

    private Long idCompetencia;
    private String nomeCompetencia;
    private Long idColaborador;
    private String nomeColaborador;
    private String sobrenomeColaborador;

}
