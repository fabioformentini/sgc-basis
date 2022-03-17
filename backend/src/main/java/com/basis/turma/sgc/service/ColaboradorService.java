package com.basis.turma.sgc.service;

import com.basis.turma.sgc.domain.*;
import com.basis.turma.sgc.repository.ColaboradorCompetenciaRepository;
import com.basis.turma.sgc.repository.ColaboradorRepository;
import com.basis.turma.sgc.repository.TurmaFormacaoCompetenciaColaboradorRepository;
import com.basis.turma.sgc.resources.exception.RegraNegocioException;
import com.basis.turma.sgc.service.dto.ColaboradorDTO;
import com.basis.turma.sgc.service.mapper.ColaboradorListaMapper;
import com.basis.turma.sgc.service.mapper.ColaboradorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ColaboradorService {

    private final ColaboradorCompetenciaRepository colaboradorCompetenciaRepository;
    private final ColaboradorRepository colaboradorRepository;
    private final TurmaFormacaoCompetenciaColaboradorRepository turmaFormacaoCompetenciaColaboradorRepository;
    private final ColaboradorMapper mapper;
    private final ColaboradorListaMapper listaMapper;


    public List<ColaboradorDTO> listar(){
        return mapper.toDTO(colaboradorRepository.findAll());
    }

    public ColaboradorDTO buscarPorId(Long id) {
        return mapper.toDTO(colaboradorRepository.findById(id).orElseThrow(() ->
                new RegraNegocioException("Colaborador não encontrado!")));
    }

    public ColaboradorDTO criar(ColaboradorDTO colaboradorDTO){
        Colaborador colaborador = mapper.toEntity(colaboradorDTO);
        Colaborador colaboradorSalvo = colaboradorRepository.save(colaborador);
        List<ColaboradorCompetencia> colaboradorCompetenciaLista = colaboradorDTO.getCompetenciasList().stream().map(competencia -> {
            ColaboradorCompetencia colaboradorCompetencia = new ColaboradorCompetencia();
            colaboradorCompetencia.setNivel(competencia.getNivel());
            colaboradorCompetencia.setColaborador(colaboradorSalvo);
            Competencia competenciaNova = new Competencia();
            competenciaNova.setId(competencia.getIdCompetencia());
            colaboradorCompetencia.setCompetencia(competenciaNova);
            IdColaboradorCompetencia idColaboradorCompetencia = new IdColaboradorCompetencia();
            idColaboradorCompetencia.setId_colaborador(colaboradorSalvo.getId());
            idColaboradorCompetencia.setId_competencia(competenciaNova.getId());
            colaboradorCompetencia.setId(idColaboradorCompetencia);
            return colaboradorCompetencia;
        }).collect(Collectors.toList());
        colaboradorCompetenciaRepository.saveAll(colaboradorCompetenciaLista);
        return mapper.toDTO(colaboradorSalvo);
    }

    public ColaboradorDTO atualizar(Long id, ColaboradorDTO colaboradorDTO){
//        colaboradorDTO.setId(id);
//        if(!colaboradorRepository.existsById(id)){
//            throw new RegraNegocioException("O colaborador de id " + id.toString() + " não existe!");
//        }
//        Colaborador colaborador = mapper.toEntity(colaboradorDTO);
//        colaborador.getCompetencias().stream().forEach((competencia) ->
//                );
        if(!colaboradorRepository.existsById(id)){
            throw new RegraNegocioException("O colaborador de id " + id.toString() + " não existe!");
        }
        Colaborador colaborador = mapper.toEntity(colaboradorDTO);
        colaborador.setId(id);
        Colaborador colaboradorSalvo = colaboradorRepository.save(colaborador);
        List<ColaboradorCompetencia> colaboradorCompetenciaLista = colaboradorDTO.getCompetenciasList().stream().map(competencia -> {
            ColaboradorCompetencia colaboradorCompetencia = new ColaboradorCompetencia();
            colaboradorCompetencia.setNivel(competencia.getNivel());
            colaboradorCompetencia.setColaborador(colaboradorSalvo);
            Competencia competenciaNova = new Competencia();
            competenciaNova.setId(competencia.getIdCompetencia());
            colaboradorCompetencia.setCompetencia(competenciaNova);
            IdColaboradorCompetencia idColaboradorCompetencia = new IdColaboradorCompetencia();
            idColaboradorCompetencia.setId_colaborador(colaboradorSalvo.getId());
            idColaboradorCompetencia.setId_competencia(competenciaNova.getId());
            colaboradorCompetencia.setId(idColaboradorCompetencia);
            return colaboradorCompetencia;
        }).collect(Collectors.toList());
        colaboradorCompetenciaRepository.deleteAllByColaboradorId(colaboradorSalvo.getId());
        colaboradorCompetenciaRepository.saveAll(colaboradorCompetenciaLista);
        return mapper.toDTO(colaboradorSalvo);
    }

//    public ColaboradorDTO atualizar(Long id, ColaboradorDTO colaboradorDTO){
//        Colaborador colaborador = mapper.toEntity(colaboradorDTO);
//        colaborador.setId(id);
//        return mapper.toDTO(colaboradorRepository.save(colaborador));
//    }

    public void deletar(Long id){
        if(!colaboradorRepository.existsById(id)){
            throw new RegraNegocioException("O colaborador de id " + id.toString() + " não existe!");
        }
        Optional<Colaborador> colaborador = colaboradorRepository.findById(id);
        if(!colaborador.get().getCompetenciasList().isEmpty()){
            throw new RegraNegocioException("O colaborador possui competências cadastradas!");
        }
        List<TurmaFormacaoCompetenciaColaborador> turmaFormacaoCompetenciaColaborador =
                turmaFormacaoCompetenciaColaboradorRepository.findAllByColaboradorId(id);
        if(!turmaFormacaoCompetenciaColaborador.isEmpty()){
            throw new RegraNegocioException("O colaborador possui vínculo com uma turma de formação!");
        }
        colaboradorRepository.deleteById(id);
    }


}
