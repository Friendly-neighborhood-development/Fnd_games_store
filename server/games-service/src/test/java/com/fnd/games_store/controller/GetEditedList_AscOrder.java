package com.fnd.games_store.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fnd.games_store.games.GamesApplication;
import com.fnd.games_store.games.dto.game.GameResponseDTO;
import com.fnd.games_store.games.repository.GameRepository;
import com.fnd.games_store.games.service.SpecificGameListService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


import static org.assertj.core.api.Assertions.*;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = GamesApplication.class)
@AutoConfigureMockMvc
@Slf4j
@Transactional
public class GetEditedList_AscOrder {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private SpecificGameListService service;

    @Autowired
    private GameRepository repository;


    private Integer page = 0;
    private Integer pageSize = 1;
    private String sortField = "name";
    private Boolean ascOrder = true;
    private Sort sortBy = Sort.by(Sort.Direction.ASC, sortField);

    private String uri = "/v1/catalogue/list?" + "page=" + page + "&" + "pageSize=" + pageSize + "&" + "sortField="+sortField + "&" + "ascOrder=" + ascOrder;

    private List<GameResponseDTO> serviceGameList;

    private ObjectMapper objectMapper = new ObjectMapper();


    @Test
    void getEditedList_ShouldReturnSpecificGamesList() throws Exception {


        log.info(uri);

        MvcResult mvcResult = this.mvc.perform(get(uri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk()).andReturn();

        String requestBody = mvcResult.getResponse().getContentAsString();

        List<GameResponseDTO> actualResult = objectMapper.readValue(requestBody, ArrayList.class);


        serviceGameList.stream().forEach(System.out::println);




//        Boolean isTestPassed = actualResult.get(0).equals(serviceGameList.get(0));

//        Boolean bool = Objects.equals(actualResult, serviceGameList);
//        assertThat(bool).isTrue();


    }



    @BeforeEach
    void testSetup(){

        serviceGameList = loadGamesListFromMockedDB();

        when(service.getSpecifiedGameList(page,pageSize, sortBy)).thenReturn(loadGamesListFromMockedDB());


    }

    private List<GameResponseDTO> loadGamesListFromMockedDB(){

        return repository.findAll(PageRequest.of(page,pageSize, sortBy)).stream().map(GameResponseDTO::new).collect(Collectors.toList());

    }


}
