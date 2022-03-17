package com.basis.turma.sgc.resource;

import com.basis.turma.sgc.SgcProjectApplication;
import com.basis.turma.sgc.builder.CompetenciaBuilder;
import com.basis.turma.sgc.util.IntTestComum;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.results.ResultMatchers;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.Matches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.ResultMatcher;
import org.testcontainers.shaded.org.hamcrest.Matchers;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SgcProjectApplication.class)
@Transactional
public class StatusResource extends IntTestComum {

    private static final String URL = "/api/status";

    @Autowired
    private CompetenciaBuilder builder;

    @Before
    public void inicializaTeste(){
        builder.setCustomizacao(null);
    }

    @Test
    public void listarTeste() throws Exception{
        builder.persistir(builder.construirEntidade());
        getMockMvc().perform(get(URL)).andExpect(status().isOk()).andExpect((ResultMatcher) jsonPath("$",Matchers.hasSize(1)));

    }

}
