package com.basis.turma.sgc.repository;

import com.basis.turma.sgc.domain.TurmaFormacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurmaFormacaoRepository extends JpaRepository<TurmaFormacao,Long> {

}
