package com.basis.turma.sgc.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "competencia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Competencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencia_competencia")
    @SequenceGenerator(name = "sequencia_competencia",
            sequenceName = "sequencia_competencia",
            allocationSize = 1)

    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id")
    private Categoria categoria;


}
