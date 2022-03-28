package com.basis.turma.sgc.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
public class ColaboradorListaDTO implements Serializable {
    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private byte[] foto;
    private LocalDate dataNascimento;
    private LocalDate dataAdmissao;
    private Long idSenioridade;
    private String descricaoSenioridade;
    private List<CompetenciaNivelDTO> competencias;
}
