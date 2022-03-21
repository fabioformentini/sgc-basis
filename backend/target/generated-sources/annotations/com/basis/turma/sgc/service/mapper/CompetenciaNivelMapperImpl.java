package com.basis.turma.sgc.service.mapper;

import com.basis.turma.sgc.domain.ColaboradorCompetencia;
import com.basis.turma.sgc.domain.Competencia;
import com.basis.turma.sgc.service.dto.CompetenciaNivelDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-17T08:33:49-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_312 (Private Build)"
)
@Component
public class CompetenciaNivelMapperImpl implements CompetenciaNivelMapper {

    @Override
    public List<CompetenciaNivelDTO> toDTO(List<ColaboradorCompetencia> entity) {
        if ( entity == null ) {
            return null;
        }

        List<CompetenciaNivelDTO> list = new ArrayList<CompetenciaNivelDTO>( entity.size() );
        for ( ColaboradorCompetencia colaboradorCompetencia : entity ) {
            list.add( toDTO( colaboradorCompetencia ) );
        }

        return list;
    }

    @Override
    public List<ColaboradorCompetencia> toEntity(List<CompetenciaNivelDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<ColaboradorCompetencia> list = new ArrayList<ColaboradorCompetencia>( dto.size() );
        for ( CompetenciaNivelDTO competenciaNivelDTO : dto ) {
            list.add( toEntity( competenciaNivelDTO ) );
        }

        return list;
    }

    @Override
    public CompetenciaNivelDTO toDTO(ColaboradorCompetencia entity) {
        if ( entity == null ) {
            return null;
        }

        CompetenciaNivelDTO competenciaNivelDTO = new CompetenciaNivelDTO();

        competenciaNivelDTO.setNomeCompetencia( entityCompetenciaNome( entity ) );
        competenciaNivelDTO.setIdCompetencia( entityCompetenciaId( entity ) );
        competenciaNivelDTO.setNivel( entity.getNivel() );

        return competenciaNivelDTO;
    }

    @Override
    public ColaboradorCompetencia toEntity(CompetenciaNivelDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ColaboradorCompetencia colaboradorCompetencia = new ColaboradorCompetencia();

        colaboradorCompetencia.setCompetencia( competenciaNivelDTOToCompetencia( dto ) );
        colaboradorCompetencia.setNivel( dto.getNivel() );

        return colaboradorCompetencia;
    }

    private String entityCompetenciaNome(ColaboradorCompetencia colaboradorCompetencia) {
        if ( colaboradorCompetencia == null ) {
            return null;
        }
        Competencia competencia = colaboradorCompetencia.getCompetencia();
        if ( competencia == null ) {
            return null;
        }
        String nome = competencia.getNome();
        if ( nome == null ) {
            return null;
        }
        return nome;
    }

    private Long entityCompetenciaId(ColaboradorCompetencia colaboradorCompetencia) {
        if ( colaboradorCompetencia == null ) {
            return null;
        }
        Competencia competencia = colaboradorCompetencia.getCompetencia();
        if ( competencia == null ) {
            return null;
        }
        Long id = competencia.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Competencia competenciaNivelDTOToCompetencia(CompetenciaNivelDTO competenciaNivelDTO) {
        if ( competenciaNivelDTO == null ) {
            return null;
        }

        Competencia competencia = new Competencia();

        competencia.setId( competenciaNivelDTO.getIdCompetencia() );

        return competencia;
    }
}
