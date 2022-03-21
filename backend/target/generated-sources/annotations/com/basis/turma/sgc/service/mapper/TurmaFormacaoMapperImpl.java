package com.basis.turma.sgc.service.mapper;

import com.basis.turma.sgc.domain.Status;
import com.basis.turma.sgc.domain.TurmaFormacao;
import com.basis.turma.sgc.service.dto.TurmaFormacaoDTO;
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
public class TurmaFormacaoMapperImpl implements TurmaFormacaoMapper {

    @Autowired
    private CompetenciaColaboradorMapper competenciaColaboradorMapper;

    @Override
    public List<TurmaFormacaoDTO> toDTO(List<TurmaFormacao> entity) {
        if ( entity == null ) {
            return null;
        }

        List<TurmaFormacaoDTO> list = new ArrayList<TurmaFormacaoDTO>( entity.size() );
        for ( TurmaFormacao turmaFormacao : entity ) {
            list.add( toDTO( turmaFormacao ) );
        }

        return list;
    }

    @Override
    public List<TurmaFormacao> toEntity(List<TurmaFormacaoDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<TurmaFormacao> list = new ArrayList<TurmaFormacao>( dto.size() );
        for ( TurmaFormacaoDTO turmaFormacaoDTO : dto ) {
            list.add( toEntity( turmaFormacaoDTO ) );
        }

        return list;
    }

    @Override
    public TurmaFormacaoDTO toDTO(TurmaFormacao entity) {
        if ( entity == null ) {
            return null;
        }

        TurmaFormacaoDTO turmaFormacaoDTO = new TurmaFormacaoDTO();

        turmaFormacaoDTO.setIdStatus( entityStatusId( entity ) );
        turmaFormacaoDTO.setDescricaoStatus( entityStatusDescricao( entity ) );
        turmaFormacaoDTO.setId( entity.getId() );
        turmaFormacaoDTO.setNome( entity.getNome() );
        turmaFormacaoDTO.setDescricao( entity.getDescricao() );
        turmaFormacaoDTO.setDataInicio( entity.getDataInicio() );
        turmaFormacaoDTO.setDataTermino( entity.getDataTermino() );
        turmaFormacaoDTO.setCompetenciasColaboradores( competenciaColaboradorMapper.toDTO( entity.getCompetenciasColaboradores() ) );

        return turmaFormacaoDTO;
    }

    @Override
    public TurmaFormacao toEntity(TurmaFormacaoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TurmaFormacao turmaFormacao = new TurmaFormacao();

        turmaFormacao.setStatus( turmaFormacaoDTOToStatus( dto ) );
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

    protected Status turmaFormacaoDTOToStatus(TurmaFormacaoDTO turmaFormacaoDTO) {
        if ( turmaFormacaoDTO == null ) {
            return null;
        }

        Status status = new Status();

        status.setId( turmaFormacaoDTO.getIdStatus() );

        return status;
    }
}
