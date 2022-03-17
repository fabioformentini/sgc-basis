package com.basis.turma.sgc.service.mapper;

import com.basis.turma.sgc.domain.TurmaFormacao;
import com.basis.turma.sgc.service.dto.TurmaFormacaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Optional;

@Mapper(componentModel = "spring", uses = {CompetenciaColaboradorMapper.class})
public interface TurmaFormacaoMapper extends EntityMapper<TurmaFormacaoDTO, TurmaFormacao> {

    @Override
    @Mapping(source = "status.id", target = "idStatus")
    @Mapping(source = "status.descricao", target = "descricaoStatus")
    TurmaFormacaoDTO toDTO(TurmaFormacao entity);

    @Override
    @Mapping(source = "idStatus", target = "status.id")
    TurmaFormacao toEntity(TurmaFormacaoDTO dto);

}
