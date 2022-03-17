package com.basis.turma.sgc.service;

import com.basis.turma.sgc.repository.StatusRepository;
import com.basis.turma.sgc.service.dto.StatusDTO;
import com.basis.turma.sgc.service.mapper.StatusMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatusService {

    @Autowired
    private final StatusRepository repository;
    private final StatusMapper mapper;

    public List<StatusDTO> listar(){
        return mapper.toDTO(repository.findAll());
    }

}
