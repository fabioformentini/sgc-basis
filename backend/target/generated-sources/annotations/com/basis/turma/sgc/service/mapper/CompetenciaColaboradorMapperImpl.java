package com.basis.turma.sgc.service.mapper;

import com.basis.turma.sgc.domain.Colaborador;
import com.basis.turma.sgc.domain.Competencia;
import com.basis.turma.sgc.domain.TurmaFormacaoCompetenciaColaborador;
import com.basis.turma.sgc.service.dto.CompetenciaColaboradorDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-17T07:28:04-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_312 (Private Build)"
)
@Component
public class CompetenciaColaboradorMapperImpl implements CompetenciaColaboradorMapper {

    @Override
    public List<CompetenciaColaboradorDTO> toDTO(List<TurmaFormacaoCompetenciaColaborador> entity) {
        if ( entity == null ) {
            return null;
        }

        List<CompetenciaColaboradorDTO> list = new ArrayList<CompetenciaColaboradorDTO>( entity.size() );
        for ( TurmaFormacaoCompetenciaColaborador turmaFormacaoCompetenciaColaborador : entity ) {
            list.add( toDTO( turmaFormacaoCompetenciaColaborador ) );
        }

        return list;
    }

    @Override
    public List<TurmaFormacaoCompetenciaColaborador> toEntity(List<CompetenciaColaboradorDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<TurmaFormacaoCompetenciaColaborador> list = new ArrayList<TurmaFormacaoCompetenciaColaborador>( dto.size() );
        for ( CompetenciaColaboradorDTO competenciaColaboradorDTO : dto ) {
            list.add( toEntity( competenciaColaboradorDTO ) );
        }

        return list;
    }

    @Override
    public CompetenciaColaboradorDTO toDTO(TurmaFormacaoCompetenciaColaborador entity) {
        if ( entity == null ) {
            return null;
        }

        CompetenciaColaboradorDTO competenciaColaboradorDTO = new CompetenciaColaboradorDTO();

        competenciaColaboradorDTO.setIdColaborador( entityColaboradorId( entity ) );
        competenciaColaboradorDTO.setSobrenomeColaborador( entityColaboradorSobrenome( entity ) );
        competenciaColaboradorDTO.setNomeCompetencia( entityCompetenciaNome( entity ) );
        competenciaColaboradorDTO.setNomeColaborador( entityColaboradorNome( entity ) );
        competenciaColaboradorDTO.setIdCompetencia( entityCompetenciaId( entity ) );

        return competenciaColaboradorDTO;
    }

    @Override
    public TurmaFormacaoCompetenciaColaborador toEntity(CompetenciaColaboradorDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TurmaFormacaoCompetenciaColaborador turmaFormacaoCompetenciaColaborador = new TurmaFormacaoCompetenciaColaborador();

        turmaFormacaoCompetenciaColaborador.setColaborador( competenciaColaboradorDTOToColaborador( dto ) );
        turmaFormacaoCompetenciaColaborador.setCompetencia( competenciaColaboradorDTOToCompetencia( dto ) );

        return turmaFormacaoCompetenciaColaborador;
    }

    private Long entityColaboradorId(TurmaFormacaoCompetenciaColaborador turmaFormacaoCompetenciaColaborador) {
        if ( turmaFormacaoCompetenciaColaborador == null ) {
            return null;
        }
        Colaborador colaborador = turmaFormacaoCompetenciaColaborador.getColaborador();
        if ( colaborador == null ) {
            return null;
        }
        Long id = colaborador.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String entityColaboradorSobrenome(TurmaFormacaoCompetenciaColaborador turmaFormacaoCompetenciaColaborador) {
        if ( turmaFormacaoCompetenciaColaborador == null ) {
            return null;
        }
        Colaborador colaborador = turmaFormacaoCompetenciaColaborador.getColaborador();
        if ( colaborador == null ) {
            return null;
        }
        String sobrenome = colaborador.getSobrenome();
        if ( sobrenome == null ) {
            return null;
        }
        return sobrenome;
    }

    private String entityCompetenciaNome(TurmaFormacaoCompetenciaColaborador turmaFormacaoCompetenciaColaborador) {
        if ( turmaFormacaoCompetenciaColaborador == null ) {
            return null;
        }
        Competencia competencia = turmaFormacaoCompetenciaColaborador.getCompetencia();
        if ( competencia == null ) {
            return null;
        }
        String nome = competencia.getNome();
        if ( nome == null ) {
            return null;
        }
        return nome;
    }

    private String entityColaboradorNome(TurmaFormacaoCompetenciaColaborador turmaFormacaoCompetenciaColaborador) {
        if ( turmaFormacaoCompetenciaColaborador == null ) {
            return null;
        }
        Colaborador colaborador = turmaFormacaoCompetenciaColaborador.getColaborador();
        if ( colaborador == null ) {
            return null;
        }
        String nome = colaborador.getNome();
        if ( nome == null ) {
            return null;
        }
        return nome;
    }

    private Long entityCompetenciaId(TurmaFormacaoCompetenciaColaborador turmaFormacaoCompetenciaColaborador) {
        if ( turmaFormacaoCompetenciaColaborador == null ) {
            return null;
        }
        Competencia competencia = turmaFormacaoCompetenciaColaborador.getCompetencia();
        if ( competencia == null ) {
            return null;
        }
        Long id = competencia.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Colaborador competenciaColaboradorDTOToColaborador(CompetenciaColaboradorDTO competenciaColaboradorDTO) {
        if ( competenciaColaboradorDTO == null ) {
            return null;
        }

        Colaborador colaborador = new Colaborador();

        colaborador.setId( competenciaColaboradorDTO.getIdColaborador() );

        return colaborador;
    }

    protected Competencia competenciaColaboradorDTOToCompetencia(CompetenciaColaboradorDTO competenciaColaboradorDTO) {
        if ( competenciaColaboradorDTO == null ) {
            return null;
        }

        Competencia competencia = new Competencia();

        competencia.setId( competenciaColaboradorDTO.getIdCompetencia() );

        return competencia;
    }
}
