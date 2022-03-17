package com.basis.turma.sgc.builder;

import com.basis.turma.sgc.domain.Categoria;
import com.basis.turma.sgc.repository.CategoriaRepository;
import com.basis.turma.sgc.resources.exception.RegraNegocioException;
import com.basis.turma.sgc.service.dto.CategoriaDTO;
import com.basis.turma.sgc.service.mapper.CategoriaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.util.resources.cldr.teo.CalendarData_teo_KE;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;

@Component
public class CategoriaBuilder extends ConstrutorDeEntidade<CategoriaDTO>{

    @Autowired
    private CategoriaMapper mapper;

    @Autowired
    private CategoriaRepository repository;

    @Override
    protected CategoriaDTO construirEntidade() throws ParseException {
        Categoria categoria = new Categoria();
        categoria.setId(10L);
        categoria.setDescricao("Teste");
        return mapper.toDTO(categoria);
    }

    @Override
    protected CategoriaDTO persistir(CategoriaDTO entidade) {
        Categoria categoria = mapper.toEntity(entidade);
        return mapper.toDTO(repository.save(categoria));
    }

    @Override
    protected Collection<CategoriaDTO> obterTodos() {
        List<Categoria> categoria = repository.findAll();
        return mapper.toDTO(categoria);
    }

    @Override
    protected CategoriaDTO obterPorId(Long id) {
        return mapper.toDTO(repository.findById(id)
                .orElseThrow(()-> new RegraNegocioException("Categoria não encontrada!")));
    }
}
