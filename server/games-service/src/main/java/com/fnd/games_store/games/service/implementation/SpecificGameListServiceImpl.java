package com.fnd.games_store.games.service.implementation;

import com.fnd.games_store.games.dto.game.GameResponseDTO;
import com.fnd.games_store.games.exceptions.GameNotFoundException;
import com.fnd.games_store.games.repository.GameRepository;
import com.fnd.games_store.games.service.SpecificGameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecificGameListServiceImpl implements SpecificGameListService {


    private final GameRepository repository;

    @Autowired
    public SpecificGameListServiceImpl(GameRepository repository) {
        this.repository = repository;
    }

    @Transactional(label = "specific_gameList_fetch",
            propagation = Propagation.REQUIRED,
            isolation = Isolation.REPEATABLE_READ,
            timeout = 5,
            readOnly = true)
    @Override
    public List<GameResponseDTO> getSpecifiedGameList(Integer page, Integer pageSize, Sort sortBy) {
        return repository.findAll(PageRequest.of(page,pageSize, sortBy)).stream().map(GameResponseDTO::new).collect(Collectors.toList());
    }



}
