package com.basis.turma.sgc.service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import java.io.Serializable;

@Getter
@Setter
public class CategoriaDTO implements Serializable {

    public Long id;

    public String descricao;

}
