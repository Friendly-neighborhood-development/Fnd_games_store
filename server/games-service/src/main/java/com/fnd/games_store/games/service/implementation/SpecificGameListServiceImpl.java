package com.fnd.games_store.games.service.implementation;

import com.fnd.games_store.games.dto.game.GameResponseDTO;
import com.fnd.games_store.games.repository.GameRepository;
import com.fnd.games_store.games.service.SpecificGameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SpecificGameListServiceImpl implements SpecificGameListService {


    private final GameRepository repository;

    @Autowired
    public SpecificGameListServiceImpl(GameRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<GameResponseDTO> getSpecifiedGameList(Integer page, Integer pageSize, Sort sortBy) {
        return repository.findAll(PageRequest.of(page,pageSize, sortBy)).stream().map(GameResponseDTO::new).collect(Collectors.toList());
    }



}
