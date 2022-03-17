package com.basis.turma.sgc.service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.bridge.IMessage;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class CompetenciaDTO implements Serializable {

    private Long id;

    @NotEmpty(message="O campo nome não pode ser vazio!")
    @Length(min = 3, max = 255, message = "O campo nome deve possuir no mínimo 3 caracteres!")
    private String nome;

    @NotEmpty(message="O campo descrição não pode ser vazio!")
    @Length(min = 3, max = 255, message = "O campo descricao deve possuir no mínimo 3 caracteres!")
    private String descricao;

    @NotNull(message = "O campo categoria não pode ser nulo!")
    private Long idCategoria;

    private String descricaoCategoria;
}
