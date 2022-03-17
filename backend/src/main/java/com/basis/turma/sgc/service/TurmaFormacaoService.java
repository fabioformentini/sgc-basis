package com.basis.turma.sgc.service;

import com.basis.turma.sgc.domain.*;
import com.basis.turma.sgc.repository.ColaboradorCompetenciaRepository;
import com.basis.turma.sgc.repository.TurmaFormacaoCompetenciaColaboradorRepository;
import com.basis.turma.sgc.repository.TurmaFormacaoRepository;
import com.basis.turma.sgc.resources.exception.RegraNegocioException;
import com.basis.turma.sgc.service.dto.TurmaFormacaoDTO;
import com.basis.turma.sgc.service.dto.TurmaFormacaoListaDTO;
import com.basis.turma.sgc.service.mapper.TurmaFormacaoListaMapper;
import com.basis.turma.sgc.service.mapper.TurmaFormacaoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TurmaFormacaoService {

    private final TurmaFormacaoRepository turmaFormacaoRepository;
    private final TurmaFormacaoMapper mapper;
    private final TurmaFormacaoListaMapper mapperLista;
    private final TurmaFormacaoCompetenciaColaboradorRepository turmaFormacaoCompetenciaColaboradorRepository;

    public List<TurmaFormacaoListaDTO> listar(){
        return mapperLista.toDTO(turmaFormacaoRepository.findAll());
    }

    public TurmaFormacaoListaDTO buscarId(Long id){
        return mapperLista.toDTO(turmaFormacaoRepository.findById(id).orElseThrow(()->
                new RegraNegocioException("Turma de formação não encontrada!")));
    }

    public TurmaFormacaoDTO criar(TurmaFormacaoDTO turmaFormacaoDTO){
        TurmaFormacao turmaFormacao = mapper.toEntity(turmaFormacaoDTO);
        TurmaFormacao turmaFormacaoSalvo = turmaFormacaoRepository.save(turmaFormacao);
        List<TurmaFormacaoCompetenciaColaborador> turmaCompetenciaColaboradorLista = turmaFormacaoDTO.getCompetenciasColaboradores().stream().map(competenciaColaborador ->{
            TurmaFormacaoCompetenciaColaborador turmaFormacaoCompetenciaColaborador = new TurmaFormacaoCompetenciaColaborador();
            turmaFormacaoCompetenciaColaborador.setTurmaFormacao(turmaFormacaoSalvo);
            Competencia competenciaNova = new Competencia();
            competenciaNova.setId(competenciaColaborador.getIdCompetencia());
            turmaFormacaoCompetenciaColaborador.setCompetencia(competenciaNova);
            Colaborador colaboradorNovo = new Colaborador();
            colaboradorNovo.setId(competenciaColaborador.getIdColaborador());
            turmaFormacaoCompetenciaColaborador.setColaborador(colaboradorNovo);
            IdTurmaFormacaoCompetenciaColaborador idTurmaCompetenciaColaborador = new IdTurmaFormacaoCompetenciaColaborador();
            idTurmaCompetenciaColaborador.setId_turma_formacao(turmaFormacaoSalvo.getId());
            idTurmaCompetenciaColaborador.setId_competencia(competenciaNova.getId());
            idTurmaCompetenciaColaborador.setId_colaborador(colaboradorNovo.getId());
            turmaFormacaoCompetenciaColaborador.setId(idTurmaCompetenciaColaborador);
            return turmaFormacaoCompetenciaColaborador;
        }).collect(Collectors.toList());
        turmaFormacaoCompetenciaColaboradorRepository.saveAll(turmaCompetenciaColaboradorLista);
        return mapper.toDTO(turmaFormacaoSalvo);
    }

    public TurmaFormacaoDTO atualizar(Long id, TurmaFormacaoDTO turmaFormacaoDTO){
        if(!turmaFormacaoRepository.existsById(id)){
            throw new RegraNegocioException("A turma de formação de id " + id.toString() + " não existe no sistema!");
        }
        TurmaFormacao turmaFormacao = mapper.toEntity(turmaFormacaoDTO);
        turmaFormacao.setId(id);
        TurmaFormacao turmaFormacaoSalvo = turmaFormacaoRepository.save(turmaFormacao);
        List<TurmaFormacaoCompetenciaColaborador> turmaCompetenciaColaboradorLista = turmaFormacaoDTO.getCompetenciasColaboradores().stream().map(competenciaColaborador ->{
            TurmaFormacaoCompetenciaColaborador turmaFormacaoCompetenciaColaborador = new TurmaFormacaoCompetenciaColaborador();
            turmaFormacaoCompetenciaColaborador.setTurmaFormacao(turmaFormacaoSalvo);
            Competencia competenciaNova = new Competencia();
            competenciaNova.setId(competenciaColaborador.getIdCompetencia());
            turmaFormacaoCompetenciaColaborador.setCompetencia(competenciaNova);
            Colaborador colaboradorNovo = new Colaborador();
            colaboradorNovo.setId(competenciaColaborador.getIdColaborador());
            turmaFormacaoCompetenciaColaborador.setColaborador(colaboradorNovo);
            IdTurmaFormacaoCompetenciaColaborador idTurmaCompetenciaColaborador = new IdTurmaFormacaoCompetenciaColaborador();
            idTurmaCompetenciaColaborador.setId_turma_formacao(turmaFormacaoSalvo.getId());
            idTurmaCompetenciaColaborador.setId_competencia(competenciaNova.getId());
            idTurmaCompetenciaColaborador.setId_colaborador(colaboradorNovo.getId());
            turmaFormacaoCompetenciaColaborador.setId(idTurmaCompetenciaColaborador);
            return turmaFormacaoCompetenciaColaborador;
        }).collect(Collectors.toList());
        turmaFormacaoCompetenciaColaboradorRepository.deleteAllByTurmaFormacaoId(turmaFormacaoSalvo.getId());
        turmaFormacaoCompetenciaColaboradorRepository.saveAll(turmaCompetenciaColaboradorLista);
        return mapper.toDTO(turmaFormacaoSalvo);
    }

    public void deletar(Long id){
        if(!turmaFormacaoRepository.existsById(id)){
            throw new RegraNegocioException("A turma de formação de id " + id.toString() + " não existe!");
        }
        Optional<TurmaFormacao> turmaFormacao = turmaFormacaoRepository.findById(id);
        if(!turmaFormacao.get().getCompetenciasColaboradores().isEmpty()){
            throw new RegraNegocioException("A turma de formação possui colaboradores e competências cadastradas!");
        }
        turmaFormacaoRepository.deleteById(id);
    }

    public void atualizarStatusConcluida(TurmaFormacaoDTO turmaFormacaoDTO){
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataConclusao = turmaFormacaoDTO.getDataTermino();
        if(turmaFormacaoDTO.getIdStatus() != 3){
            if(dataConclusao.isBefore(dataAtual) || dataConclusao.isEqual(dataAtual)){
                turmaFormacaoDTO.setIdStatus(3L);
                TurmaFormacao turmaFormacao = mapper.toEntity(turmaFormacaoDTO);
                turmaFormacao.setId(turmaFormacaoDTO.getId());
                turmaFormacao.setDataInicio(turmaFormacaoDTO.getDataInicio());
                turmaFormacao.setDataTermino(turmaFormacaoDTO.getDataTermino());
                turmaFormacaoRepository.save(turmaFormacao);
            }
        }
    }

    public void atualizarStatusIniciada(TurmaFormacaoDTO turmaFormacaoDTO){
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataInicio = turmaFormacaoDTO.getDataInicio();
        if(turmaFormacaoDTO.getIdStatus() != 2){
            if(dataInicio.isBefore(dataAtual) || dataInicio.isEqual(dataAtual)){
                turmaFormacaoDTO.setIdStatus(2L);
                TurmaFormacao turmaFormacao = mapper.toEntity(turmaFormacaoDTO);
                turmaFormacao.setId(turmaFormacaoDTO.getId());
                turmaFormacao.setDataInicio(turmaFormacaoDTO.getDataInicio());
                turmaFormacao.setDataTermino(turmaFormacaoDTO.getDataTermino());
                turmaFormacaoRepository.save(turmaFormacao);
            }
        }
    }



}
