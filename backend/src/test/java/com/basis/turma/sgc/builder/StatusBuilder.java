package com.basis.turma.sgc.builder;

import com.basis.turma.sgc.domain.Status;
import com.basis.turma.sgc.repository.StatusRepository;
import com.basis.turma.sgc.resources.exception.RegraNegocioException;
import com.basis.turma.sgc.service.dto.StatusDTO;
import com.basis.turma.sgc.service.mapper.StatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;

@Component
public class StatusBuilder extends ConstrutorDeEntidade<StatusDTO>{

    @Autowired
    private StatusMapper mapper;

    @Autowired
    private StatusRepository repository;

    @Override
    protected StatusDTO construirEntidade() throws ParseException {
        Status status = new Status();
        status.setId(10L);
        status.setDescricao("Teste");
        return mapper.toDTO(status);
    }

    @Override
    protected StatusDTO persistir(StatusDTO entidade) {
        Status status = mapper.toEntity(entidade);
        return mapper.toDTO(repository.save(status));
    }

    @Override
    protected Collection<StatusDTO> obterTodos() {
        List<Status> status = repository.findAll();
        return mapper.toDTO(status);
    }

    @Override
    protected StatusDTO obterPorId(Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(()->
                new RegraNegocioException("Status não encontrado!")));
    }
}
