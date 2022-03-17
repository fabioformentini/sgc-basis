package com.basis.turma.sgc.resource;

import com.basis.turma.sgc.SgcProjectApplication;
import com.basis.turma.sgc.builder.CompetenciaBuilder;
import com.basis.turma.sgc.service.CompetenciaService;
import com.basis.turma.sgc.service.dto.CompetenciaDTO;
import com.basis.turma.sgc.service.mapper.CompetenciaMapper;
import com.basis.turma.sgc.util.IntTestComum;
import com.basis.turma.sgc.util.TestUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.testcontainers.shaded.org.hamcrest.Matchers;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SgcProjectApplication.class)
@Transactional
public class CompetenciaResource extends IntTestComum {

    private static final String URL = "/api/competencia";

    @Autowired
    private CompetenciaMapper mapper;

    @Autowired
    private CompetenciaService competenciaService;

    @Autowired
    private CompetenciaBuilder competenciaBuilder;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void inicializaTeste(){
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        competenciaBuilder.setCustomizacao(null);
        // competenciaBuilder.setCustomizacao(null)
    }

    @Test
    public void listarTest()throws Exception{

        competenciaBuilder.persistir(competenciaBuilder.construirEntidade());

        getMockMvc().perform(get(URL))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$", Matchers.hasSize(1)));
    }

//    @Test
//    public void salvarTest() throws Exception{
//        CompetenciaDTO dto = competenciaBuilder.construirEntidade();
//
//        getMockMvc().perform(MockMvcRequestBuilders.post(URL)
//                .contentType(TestUtil.APPLICATION_JSON_UTF8)
//                .content(TestUtil.convertObjectToJsonBytes(dto))
//                .andExpect(status().isCreated()));
//
//    }

//    @Test
//    public void editTest() throws Exception{ // PERGUNTAR O QUE MUDOU
//        CompetenciaDTO dto = competenciaBuilder.construirEntidade();
//
//        getMockMvc().perform(MockMvcRequestBuilders.post(URL)
//                .content(TestUtil.convertObjectToJsonBytes(dto))
//                .contentType(TestUtil.APPLICATION_JSON_UTF8)
//                .accept((MediaType) status().isCreated()));
//    }

//    @Test
//    public void deleteTest() throws Exception{
//        getMockMvc().perform(URL + "/" + 999).contentType(TestUtil.APPLICATION_JSON_UTF8)
//                .andExpect(status().isBadRequest());
//    }

//    @Test
//    public void deleteFalhouTest() throws Exception{
//        CompetenciaDTO dto = competenciaBuilder.persistir(competenciaBuilder.construirEntidade());
//
//        getMockMvc().perform(URL + "/" + dto.getId())
//                .contentType(TestUtil.APPLICATION_JSON_UTF8)
//                .andExpect(status().isBadRequest());
//    }

//    @Test
//    public void editRetornoTest() throws Exception{ // PERGUNTAR O QUE MUDOU
//        CompetenciaDTO dto = competenciaBuilder.persistir(competenciaBuilder.construirEntidade());
//
//        dto.setNome("Jagi");
//
//        getMockMvc().perform(post(URL))
//                .contentType(TestUtil.APPLICATION_JSON_UTF8)
//                .content(TestUtil.convertObjectToJsonBytes(dto))
//                .andExpect(status().isOk())
//                .andExcept(jsonPath("$.descricao").value("Aula"));
//
//    }

//    @Test
//    @SneakyThrows
//     public void pegarTodosTeste(){
//        mockMvc.perform(get(URL)).andExpect(status().isOk());
//    }

}
