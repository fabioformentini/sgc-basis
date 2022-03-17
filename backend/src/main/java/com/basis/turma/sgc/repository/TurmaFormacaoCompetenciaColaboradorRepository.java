package com.basis.turma.sgc.repository;

import com.basis.turma.sgc.domain.IdTurmaFormacaoCompetenciaColaborador;
import com.basis.turma.sgc.domain.TurmaFormacaoCompetenciaColaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurmaFormacaoCompetenciaColaboradorRepository extends JpaRepository<TurmaFormacaoCompetenciaColaborador, IdTurmaFormacaoCompetenciaColaborador> {
    void deleteAllByTurmaFormacaoId(Long id);

    List<TurmaFormacaoCompetenciaColaborador> findAllByColaboradorIdAndCompetenciaId(Long colaboradorId, Long competenciaId);

    List<TurmaFormacaoCompetenciaColaborador> findAllByColaboradorId(Long id);
}
