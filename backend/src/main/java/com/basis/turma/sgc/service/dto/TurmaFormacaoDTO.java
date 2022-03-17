package com.basis.turma.sgc.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class TurmaFormacaoDTO implements Serializable {

    private Long id;
    @NotEmpty(message = "O campo nome não pode ser vazio!")
    @Length(min = 3, max = 255, message = "O campo nome deve possuir no mínimo 3 caracteres!")
    private String nome;
    @NotEmpty(message = "O campo descrição não pode ser vazio!")
    @Length(min = 3, max = 255, message = "O campo descrição deve possuir no mínimo 3 caracteres!")
    private String descricao;
    @NotNull(message = "O campo data de início não pode ser nulo!")
    private LocalDate dataInicio;
    @NotNull(message = "O campo data de término não pode ser nulo!")
    private LocalDate dataTermino;
    @NotNull(message = "O campo status não pode ser nulo!")
    private Long idStatus;
    private String descricaoStatus;
//    @Size(min = 1, message = "Uma turma de formação deve possuir no mínimo uma competência!")
    private List<CompetenciaColaboradorDTO> competenciasColaboradores = new ArrayList<>();

}
