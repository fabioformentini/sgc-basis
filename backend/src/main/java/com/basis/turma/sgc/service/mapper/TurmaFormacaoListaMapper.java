package com.basis.turma.sgc.service.mapper;

import com.basis.turma.sgc.domain.TurmaFormacao;
import com.basis.turma.sgc.service.dto.TurmaFormacaoListaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CompetenciaColaboradorMapper.class})
public interface TurmaFormacaoListaMapper extends EntityMapper<TurmaFormacaoListaDTO, TurmaFormacao>{

    @Override
    @Mapping(source = "status.id", target = "idStatus")
    @Mapping(source = "status.descricao", target = "descricaoStatus")
    TurmaFormacaoListaDTO toDTO(TurmaFormacao entity);

    @Override
    @Mapping(source = "idStatus", target = "status.id")
    TurmaFormacao toEntity(TurmaFormacaoListaDTO dto);

}
