package com.basis.turma.sgc.service.mapper;

import com.basis.turma.sgc.domain.Senioridade;
import com.basis.turma.sgc.service.dto.SenioridadeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SenioridadeMapper extends EntityMapper<SenioridadeDTO,Senioridade>{

}
