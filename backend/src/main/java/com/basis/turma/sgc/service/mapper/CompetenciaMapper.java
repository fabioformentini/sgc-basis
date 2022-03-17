package com.basis.turma.sgc.service.mapper;

import com.basis.turma.sgc.domain.Competencia;
import com.basis.turma.sgc.service.dto.CompetenciaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompetenciaMapper extends EntityMapper<CompetenciaDTO, Competencia>{

    @Override
    @Mapping(source="categoria.id", target = "idCategoria")
    @Mapping(source="categoria.descricao", target = "descricaoCategoria")
    CompetenciaDTO toDTO(Competencia competencia);

    @Override
    @Mapping(source="idCategoria", target = "categoria.id")
    @Mapping(source = "descricaoCategoria", target = "categoria.descricao")
    Competencia toEntity(CompetenciaDTO dto);

}
