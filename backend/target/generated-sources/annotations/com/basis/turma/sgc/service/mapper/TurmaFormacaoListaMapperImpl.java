package com.basis.turma.sgc.service.mapper;

import com.basis.turma.sgc.domain.Status;
import com.basis.turma.sgc.domain.TurmaFormacao;
import com.basis.turma.sgc.service.dto.TurmaFormacaoListaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-17T08:33:49-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_312 (Private Build)"
)
@Component
public class TurmaFormacaoListaMapperImpl implements TurmaFormacaoListaMapper {

    @Autowired
    private CompetenciaColaboradorMapper competenciaColaboradorMapper;

    @Override
    public List<TurmaFormacaoListaDTO> toDTO(List<TurmaFormacao> entity) {
        if ( entity == null ) {
            return null;
        }

        List<TurmaFormacaoListaDTO> list = new ArrayList<TurmaFormacaoListaDTO>( entity.size() );
        for ( TurmaFormacao turmaFormacao : entity ) {
            list.add( toDTO( turmaFormacao ) );
        }

        return list;
    }

    @Override
    public List<TurmaFormacao> toEntity(List<TurmaFormacaoListaDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<TurmaFormacao> list = new ArrayList<TurmaFormacao>( dto.size() );
        for ( TurmaFormacaoListaDTO turmaFormacaoListaDTO : dto ) {
            list.add( toEntity( turmaFormacaoListaDTO ) );
        }

        return list;
    }

    @Override
    public TurmaFormacaoListaDTO toDTO(TurmaFormacao entity) {
        if ( entity == null ) {
            return null;
        }

        TurmaFormacaoListaDTO turmaFormacaoListaDTO = new TurmaFormacaoListaDTO();

        turmaFormacaoListaDTO.setIdStatus( entityStatusId( entity ) );
        turmaFormacaoListaDTO.setDescricaoStatus( entityStatusDescricao( entity ) );
        turmaFormacaoListaDTO.setId( entity.getId() );
        turmaFormacaoListaDTO.setNome( entity.getNome() );
        turmaFormacaoListaDTO.setDescricao( entity.getDescricao() );
        turmaFormacaoListaDTO.setDataInicio( entity.getDataInicio() );
        turmaFormacaoListaDTO.setDataTermino( entity.getDataTermino() );
        turmaFormacaoListaDTO.setCompetenciasColaboradores( competenciaColaboradorMapper.toDTO( entity.getCompetenciasColaboradores() ) );

        return turmaFormacaoListaDTO;
    }

    @Override
    public TurmaFormacao toEntity(TurmaFormacaoListaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TurmaFormacao turmaFormacao = new TurmaFormacao();

        turmaFormacao.setStatus( turmaFormacaoListaDTOToStatus( dto ) );
        turmaFormacao.setId( dto.getId() );
        turmaFormacao.setNome( dto.getNome() );
        turmaFormacao.setDescricao( dto.getDescricao() );
        turmaFormacao.setDataInicio( dto.getDataInicio() );
        turmaFormacao.setDataTermino( dto.getDataTermino() );
        turmaFormacao.setCompetenciasColaboradores( competenciaColaboradorMapper.toEntity( dto.getCompetenciasColaboradores() ) );

        return turmaFormacao;
    }

    private Long entityStatusId(TurmaFormacao turmaFormacao) {
        if ( turmaFormacao == null ) {
            return null;
        }
        Status status = turmaFormacao.getStatus();
        if ( status == null ) {
            return null;
        }
        Long id = status.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String entityStatusDescricao(TurmaFormacao turmaFormacao) {
        if ( turmaFormacao == null ) {
            return null;
        }
        Status status = turmaFormacao.getStatus();
        if ( status == null ) {
            return null;
        }
        String descricao = status.getDescricao();
        if ( descricao == null ) {
            return null;
        }
        return descricao;
    }

    protected Status turmaFormacaoListaDTOToStatus(TurmaFormacaoListaDTO turmaFormacaoListaDTO) {
        if ( turmaFormacaoListaDTO == null ) {
            return null;
        }

        Status status = new Status();

        status.setId( turmaFormacaoListaDTO.getIdStatus() );

        return status;
    }
}
