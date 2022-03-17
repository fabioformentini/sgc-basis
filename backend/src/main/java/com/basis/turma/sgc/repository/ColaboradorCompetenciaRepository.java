package com.basis.turma.sgc.repository;

import com.basis.turma.sgc.domain.ColaboradorCompetencia;
import com.basis.turma.sgc.domain.IdColaboradorCompetencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColaboradorCompetenciaRepository extends JpaRepository<ColaboradorCompetencia, IdColaboradorCompetencia> {
    void deleteAllByColaboradorId(Long id);

    List<ColaboradorCompetencia> findAllByCompetenciaId(Long id);

    List<ColaboradorCompetencia> findAllByColaboradorIdAndCompetenciaId(Long colaboradorId, Long competenciaId);
}

