package com.basis.turma.sgc.builder;

import com.basis.turma.sgc.domain.Categoria;
import com.basis.turma.sgc.domain.Competencia;
import com.basis.turma.sgc.repository.CompetenciaRepository;
import com.basis.turma.sgc.resources.exception.RegraNegocioException;
import com.basis.turma.sgc.service.CompetenciaService;
import com.basis.turma.sgc.service.dto.CompetenciaDTO;
import com.basis.turma.sgc.service.mapper.CompetenciaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;

@Component
public class CompetenciaBuilder extends ConstrutorDeEntidade<CompetenciaDTO>{

    @Autowired
    private CompetenciaRepository competenciaRepository;

    @Autowired
    private CompetenciaService competenciaService;

    @Autowired
    private CompetenciaMapper competenciaMapper;

    @Override
    public CompetenciaDTO construirEntidade() throws ParseException {
        Competencia competencia = new Competencia();
        competencia.setNome("Git");
        competencia.setDescricao("Versionamento de código");
        //CategoriaEntity categoria = new CategoriaEntity(CategoriaEnum.ARQUITETURA);
        Categoria novaCategoria = new Categoria(10L,"Versionamento");
        competencia.setCategoria(novaCategoria);
        return competenciaMapper.toDTO(competencia);
    }

    @Override
    public CompetenciaDTO persistir(CompetenciaDTO entidade) {
        return competenciaMapper.toDTO(competenciaRepository.save(competenciaMapper.toEntity(entidade)));
    }

    @Override
    protected Collection<CompetenciaDTO> obterTodos() {
        return null;
    }


    @Override
    public CompetenciaDTO obterPorId(Long id) {
        return competenciaMapper.toDTO(competenciaRepository.findById(id).orElseThrow(()->
                new RegraNegocioException("Competencia não encontrada !")));
    }
}
