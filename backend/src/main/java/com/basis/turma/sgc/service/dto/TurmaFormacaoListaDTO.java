package com.basis.turma.sgc.service.dto;

import com.basis.turma.sgc.domain.TurmaFormacaoCompetenciaColaborador;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
public class TurmaFormacaoListaDTO implements Serializable {

    private Long id;
    private String nome;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private Long idStatus;
    private String descricaoStatus;
    private List<CompetenciaColaboradorDTO> competenciasColaboradores;

}
