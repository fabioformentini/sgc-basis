package com.basis.turma.sgc.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
public class ColaboradorListaDTO implements Serializable {
    public Long id;
    public String nome;
    public String sobrenome;
    public String email;
    private LocalDate dataNascimento;
    private LocalDate dataAdmissao;
    private Long idSenioridade;
    private String descricaoSenioridade;
    private List<CompetenciaNivelDTO> competencias;
}
