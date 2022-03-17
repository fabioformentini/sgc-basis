package com.basis.turma.sgc.service.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class ColaboradorDTO implements Serializable {
    public Long id;

    @Length(min = 3, max = 255, message = "O campo nome deve possuir no mínimo 3 caracteres!")
    @NotEmpty(message = "O campo nome não pode ser vazio!")
    public String nome;

    @Length(min = 3, max = 255, message = "O campo sobrenome deve possuir no mínimo 3 caracteres!")
    @NotEmpty(message = "O campo sobrenome não pode ser vazio!")
    public String sobrenome;

    @Length(min = 11, message = "O campo CPF deve possuir 11 caracteres")
    @NotEmpty(message = "O campo CPF não pode ser vazio!")
    @CPF(message = "O campo CPF deve ser válido!")
    public String cpf;

    @NotEmpty(message = "O campo email não pode ser vazio!")
    @Email (message = "O campo email deve ser válido!")
    public String email;

    private String foto;

    @NotNull(message = "O campo data de nascimento não pode ser nulo!")
    @PastOrPresent(message = "O campo data de nascimento deve ser válido!")
    private LocalDate dataNascimento;

    @NotNull(message = "O campo data de admissão não pode ser nulo!")
    private LocalDate dataAdmissao;

    @NotNull(message = "O campo senioridade não pode ser nulo")
    private Long idSenioridade;

    private String descricaoSenioridade;

    List<CompetenciaNivelDTO> competenciasList = new ArrayList<>();
}