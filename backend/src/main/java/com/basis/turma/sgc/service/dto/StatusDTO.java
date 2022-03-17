package com.basis.turma.sgc.service.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;

@Data
public class StatusDTO implements Serializable {

    private Long id;

    private String descricao;

}
