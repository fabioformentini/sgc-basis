package com.basis.turma.sgc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="status")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Status implements Serializable {

    @Id
    @Column(name="id")
    private Long id;
    @Column(name="descricao")
    private String descricao;

}
