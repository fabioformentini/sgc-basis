package com.basis.turma.sgc.service.mapper;
import com.basis.turma.sgc.service.dto.ColaboradorListaDTO;
import com.basis.turma.sgc.domain.Colaborador;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {CompetenciaNivelMapper.class})
public interface ColaboradorListaMapper extends EntityMapper<ColaboradorListaDTO, Colaborador> {

    @Override
    @Mapping(source = "senioridade.id", target = "idSenioridade")
    @Mapping(source = "senioridade.descricao", target = "descricaoSenioridade")
    ColaboradorListaDTO toDTO(Colaborador colaborador);

    @Override
    @Mapping(source = "idSenioridade", target = "senioridade.id")
    Colaborador toEntity(ColaboradorListaDTO dto);

}