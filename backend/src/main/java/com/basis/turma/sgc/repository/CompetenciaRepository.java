package com.basis.turma.sgc.repository;

import com.basis.turma.sgc.domain.Competencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenciaRepository extends JpaRepository<Competencia,Long> {

}
