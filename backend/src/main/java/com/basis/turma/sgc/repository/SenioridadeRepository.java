package com.basis.turma.sgc.repository;

import com.basis.turma.sgc.domain.Senioridade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SenioridadeRepository extends JpaRepository<Senioridade,Long> {
}
