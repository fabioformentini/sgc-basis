package com.basis.turma.sgc.service.mapper;

import com.basis.turma.sgc.domain.Status;
import com.basis.turma.sgc.service.dto.StatusDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StatusMapper extends EntityMapper<StatusDTO, Status>{

}
