package com.basis.turma.sgc.service;


import com.basis.turma.sgc.repository.SenioridadeRepository;
import com.basis.turma.sgc.service.dto.SenioridadeDTO;
import com.basis.turma.sgc.service.mapper.SenioridadeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SenioridadeService {

    @Autowired
    private final SenioridadeRepository repository;
    private final SenioridadeMapper mapper;

    public List<SenioridadeDTO> listar(){
        return mapper.toDTO(repository.findAll());
    }

}
