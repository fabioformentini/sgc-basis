package com.basis.turma.sgc.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity (name = "senioridade")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Senioridade implements Serializable {
    @Id
    @Column(name="id")
    private Long id;
    @Column(name="descricao")
    private String descricao;

}
