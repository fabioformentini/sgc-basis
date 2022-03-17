package com.basis.turma.sgc.service.mapper;

import com.basis.turma.sgc.domain.ColaboradorCompetencia;
import com.basis.turma.sgc.service.dto.CompetenciaNivelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompetenciaNivelMapper extends EntityMapper<CompetenciaNivelDTO, ColaboradorCompetencia>{

    @Override
    @Mapping(source = "competencia.id", target = "idCompetencia")
    @Mapping(source = "competencia.nome",target = "nomeCompetencia")
    CompetenciaNivelDTO toDTO(ColaboradorCompetencia entity);

    @Override
    @Mapping(source = "idCompetencia", target = "competencia.id")
    ColaboradorCompetencia toEntity(CompetenciaNivelDTO dto);

}
