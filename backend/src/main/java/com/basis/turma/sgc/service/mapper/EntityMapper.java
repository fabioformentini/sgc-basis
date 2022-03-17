package com.basis.turma.sgc.service.mapper;

import java.util.List;

public interface EntityMapper<D,E>{
    D toDTO (E entity);
    E toEntity (D dto);

    List<D> toDTO (List<E> entity);
    List<E> toEntity (List<D> dto);
}
