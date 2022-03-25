package com.basis.turma.sgc.repository;

import com.basis.turma.sgc.domain.IdTurmaFormacaoCompetenciaColaborador;
import com.basis.turma.sgc.domain.TurmaFormacaoCompetenciaColaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TurmaFormacaoCompetenciaColaboradorRepository extends JpaRepository<TurmaFormacaoCompetenciaColaborador, IdTurmaFormacaoCompetenciaColaborador> {
    void deleteAllByTurmaFormacaoId(Long id);

    List<TurmaFormacaoCompetenciaColaborador> findAllByColaboradorIdAndCompetenciaId(Long colaboradorId, Long competenciaId);

    List<TurmaFormacaoCompetenciaColaborador> findAllByColaboradorId(Long id);

    @Query(
            "select tfcc from TurmaFormacaoCompetenciaColaborador tfcc where " +
                    "tfcc.colaborador.id = :idColaborador and " +
                    "tfcc.competencia.id = :idCompetencia"
    )
    Optional<TurmaFormacaoCompetenciaColaborador> findByColaboradorIdAndCompetenciaId(@Param("idColaborador") Long idColaborador,
                                                                                      @Param("idCompetencia") Long idCompetencia);
}
