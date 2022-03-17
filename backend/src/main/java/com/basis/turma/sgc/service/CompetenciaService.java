package com.basis.turma.sgc.service;


import com.basis.turma.sgc.domain.ColaboradorCompetencia;
import com.basis.turma.sgc.domain.Competencia;
import com.basis.turma.sgc.domain.TurmaFormacao;
import com.basis.turma.sgc.repository.ColaboradorCompetenciaRepository;
import com.basis.turma.sgc.resources.exception.RegraNegocioException;
import com.basis.turma.sgc.service.dto.CompetenciaDTO;

import com.basis.turma.sgc.repository.CompetenciaRepository;
import com.basis.turma.sgc.service.dto.TurmaFormacaoDTO;
import com.basis.turma.sgc.service.mapper.CompetenciaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompetenciaService {

    @Autowired
    private final CompetenciaRepository competenciaRepository;
    private final ColaboradorCompetenciaRepository colaboradorCompetenciaRepository;
    private final CompetenciaMapper competenciaMapper;

    public List<CompetenciaDTO> listar(){
        return competenciaMapper.toDTO(competenciaRepository.findAll());
    }

    public CompetenciaDTO criar(CompetenciaDTO competenciaDTO){
        Competencia competencia = competenciaMapper.toEntity(competenciaDTO);
        return competenciaMapper.toDTO(competenciaRepository.save(competencia));
    }

    public CompetenciaDTO buscarPorId(Long id){
        return competenciaMapper.toDTO(competenciaRepository.findById(id).orElseThrow(()->
                new RegraNegocioException("Competencia não encontrada !")));
    }

    public CompetenciaDTO atualizar(Long id, CompetenciaDTO competenciaDTO){
        Competencia competencia = competenciaMapper.toEntity(competenciaDTO);
        competencia.setId(id);
        return competenciaMapper.toDTO(competenciaRepository.save(competencia));
    }

    public void deletar(Long id){
        if(!competenciaRepository.existsById(id)){
            throw new RegraNegocioException("A competência de id " + id.toString() + " não existe!");
        }
        List<ColaboradorCompetencia> colaboradorCompetencia = colaboradorCompetenciaRepository.findAllByCompetenciaId(id);
        if(!colaboradorCompetencia.isEmpty()){
            throw new RegraNegocioException("Um colaborador possui essa competência cadastrada!");
        }
        competenciaRepository.deleteById(id);
    }

}