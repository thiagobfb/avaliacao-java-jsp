package com.thiagobfb.avaliacaojavajsp.controller;

import com.thiagobfb.avaliacaojavajsp.domain.Projeto;
import com.thiagobfb.avaliacaojavajsp.services.ProjetoService;
import org.junit.jupiter.api.Test;
import org.mockito.AdditionalAnswers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.ArgumentMatchers.any;

@WebMvcTest(ProjetoController.class)
public class ProjetoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjetoService service;

    @Test
    public void whenViewProjetos_thenReturnProjetosView() throws Exception {
        when(service.getProjetos()).thenReturn(existingProjetos());
        ResultActions viewBooksResult = mockMvc.perform(get("/projeto/addProjeto"));

        viewBooksResult.andExpect(view().name("view-projetos"))
                .andExpect(model().attribute("projetos", hasSize(3)));
    }

    @Test
    public void whenAddBookView_thenReturnAddBooksView() throws Exception {
        ResultActions addBookViewResult = mockMvc.perform(get("/book/addBook"));

        addBookViewResult.andExpect(view().name("add-book"))
                .andExpect(model().attribute("projeto", isA(Projeto.class)));
    }

    @Test
    public void whenAddProjetoPost_thenRedirectToAddProjetoView() throws Exception {
        when(service.addProjeto(any(Projeto.class))).thenAnswer(AdditionalAnswers.returnsFirstArg());
        MockHttpServletRequestBuilder addProjetoRequest = MockMvcRequestBuilders.post("/projeto/addProjeto")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .param("isbn", "isbn1")
                .param("name", "name1")
                .param("author", "author1");
        ResultActions addBookResult = mockMvc.perform(addProjetoRequest);

        addBookResult.andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/projeto/addProjeto"))
                .andExpect(flash().attribute("savedBook", hasProperty("isbn", equalTo("isbn1"))))
                .andExpect(flash().attribute("addBookSuccess", true));
    }

    private static List<Projeto> existingProjetos() {
        List<Projeto> projetos = new ArrayList<>();
        projetos.add(Projeto.builder().id(1L).build());
        projetos.add(Projeto.builder().id(2L).build());
        projetos.add(Projeto.builder().id(3L).build());
        return projetos;
    }
}
