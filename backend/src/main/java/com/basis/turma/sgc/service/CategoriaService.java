package com.basis.turma.sgc.service;

import com.basis.turma.sgc.repository.CategoriaRepository;
import com.basis.turma.sgc.service.dto.CategoriaDTO;
import com.basis.turma.sgc.service.mapper.CategoriaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    @Autowired
    private final CategoriaRepository repository;
    private final CategoriaMapper mapper;

    public List<CategoriaDTO> listar(){
        return mapper.toDTO(repository.findAll());
    }

}
