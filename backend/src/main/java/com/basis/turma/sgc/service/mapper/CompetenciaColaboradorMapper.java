package com.basis.turma.sgc.service.mapper;

import com.basis.turma.sgc.domain.TurmaFormacaoCompetenciaColaborador;
import com.basis.turma.sgc.service.dto.CompetenciaColaboradorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompetenciaColaboradorMapper extends EntityMapper<CompetenciaColaboradorDTO, TurmaFormacaoCompetenciaColaborador>{

    @Override
    @Mapping(source = "competencia.id", target = "idCompetencia")
    @Mapping(source = "colaborador.id", target = "idColaborador")
    @Mapping(source = "competencia.nome", target = "nomeCompetencia")
    @Mapping(source = "colaborador.nome", target = "nomeColaborador")
    @Mapping(source = "colaborador.sobrenome", target = "sobrenomeColaborador")
    CompetenciaColaboradorDTO toDTO(TurmaFormacaoCompetenciaColaborador entity);

    @Override
    @Mapping(source = "idCompetencia", target = "competencia.id")
    @Mapping(source = "idColaborador", target = "colaborador.id")
    TurmaFormacaoCompetenciaColaborador toEntity(CompetenciaColaboradorDTO dto);

}
