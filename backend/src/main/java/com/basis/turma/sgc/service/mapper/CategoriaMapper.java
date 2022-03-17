package com.basis.turma.sgc.service.mapper;

import com.basis.turma.sgc.domain.Categoria;
import com.basis.turma.sgc.service.dto.CategoriaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoriaMapper extends EntityMapper<CategoriaDTO, Categoria>{

}

