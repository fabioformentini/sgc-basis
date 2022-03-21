package com.basis.turma.sgc.service.mapper;

import com.basis.turma.sgc.domain.Categoria;
import com.basis.turma.sgc.domain.Competencia;
import com.basis.turma.sgc.service.dto.CompetenciaDTO;
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
public class CompetenciaMapperImpl implements CompetenciaMapper {

    @Override
    public List<CompetenciaDTO> toDTO(List<Competencia> entity) {
        if ( entity == null ) {
            return null;
        }

        List<CompetenciaDTO> list = new ArrayList<CompetenciaDTO>( entity.size() );
        for ( Competencia competencia : entity ) {
            list.add( toDTO( competencia ) );
        }

        return list;
    }

    @Override
    public List<Competencia> toEntity(List<CompetenciaDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<Competencia> list = new ArrayList<Competencia>( dto.size() );
        for ( CompetenciaDTO competenciaDTO : dto ) {
            list.add( toEntity( competenciaDTO ) );
        }

        return list;
    }

    @Override
    public CompetenciaDTO toDTO(Competencia competencia) {
        if ( competencia == null ) {
            return null;
        }

        CompetenciaDTO competenciaDTO = new CompetenciaDTO();

        competenciaDTO.setIdCategoria( competenciaCategoriaId( competencia ) );
        competenciaDTO.setDescricaoCategoria( competenciaCategoriaDescricao( competencia ) );
        competenciaDTO.setId( competencia.getId() );
        competenciaDTO.setNome( competencia.getNome() );
        competenciaDTO.setDescricao( competencia.getDescricao() );

        return competenciaDTO;
    }

    @Override
    public Competencia toEntity(CompetenciaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Competencia competencia = new Competencia();

        competencia.setCategoria( competenciaDTOToCategoria( dto ) );
        competencia.setId( dto.getId() );
        competencia.setNome( dto.getNome() );
        competencia.setDescricao( dto.getDescricao() );

        return competencia;
    }

    private Long competenciaCategoriaId(Competencia competencia) {
        if ( competencia == null ) {
            return null;
        }
        Categoria categoria = competencia.getCategoria();
        if ( categoria == null ) {
            return null;
        }
        Long id = categoria.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String competenciaCategoriaDescricao(Competencia competencia) {
        if ( competencia == null ) {
            return null;
        }
        Categoria categoria = competencia.getCategoria();
        if ( categoria == null ) {
            return null;
        }
        String descricao = categoria.getDescricao();
        if ( descricao == null ) {
            return null;
        }
        return descricao;
    }

    protected Categoria competenciaDTOToCategoria(CompetenciaDTO competenciaDTO) {
        if ( competenciaDTO == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setDescricao( competenciaDTO.getDescricaoCategoria() );
        categoria.setId( competenciaDTO.getIdCategoria() );

        return categoria;
    }
}
