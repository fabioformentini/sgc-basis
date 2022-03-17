package com.basis.turma.sgc.service.mapper;

import com.basis.turma.sgc.domain.Categoria;
import com.basis.turma.sgc.service.dto.CategoriaDTO;
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
public class CategoriaMapperImpl implements CategoriaMapper {

    @Override
    public CategoriaDTO toDTO(Categoria entity) {
        if ( entity == null ) {
            return null;
        }

        CategoriaDTO categoriaDTO = new CategoriaDTO();

        categoriaDTO.setId( entity.getId() );
        categoriaDTO.setDescricao( entity.getDescricao() );

        return categoriaDTO;
    }

    @Override
    public Categoria toEntity(CategoriaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setId( dto.getId() );
        categoria.setDescricao( dto.getDescricao() );

        return categoria;
    }

    @Override
    public List<CategoriaDTO> toDTO(List<Categoria> entity) {
        if ( entity == null ) {
            return null;
        }

        List<CategoriaDTO> list = new ArrayList<CategoriaDTO>( entity.size() );
        for ( Categoria categoria : entity ) {
            list.add( toDTO( categoria ) );
        }

        return list;
    }

    @Override
    public List<Categoria> toEntity(List<CategoriaDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<Categoria> list = new ArrayList<Categoria>( dto.size() );
        for ( CategoriaDTO categoriaDTO : dto ) {
            list.add( toEntity( categoriaDTO ) );
        }

        return list;
    }
}
