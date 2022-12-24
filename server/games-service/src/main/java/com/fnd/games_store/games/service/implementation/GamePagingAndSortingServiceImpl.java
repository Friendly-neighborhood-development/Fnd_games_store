package com.fnd.games_store.games.service.implementation;

import com.fnd.games_store.games.dto.GameResponseDTO;
import com.fnd.games_store.games.repository.GameRepository;
import com.fnd.games_store.games.service.GamePagingAndSortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GamePagingAndSortingServiceImpl implements GamePagingAndSortingService {


    private final GameRepository repository;

    @Autowired
    public GamePagingAndSortingServiceImpl(GameRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<GameResponseDTO> getSpecifiedGameList(Integer page, Integer pageSize, Sort sort) {
        return repository.findAll(PageRequest.of(page,pageSize, sort)).stream().map(GameResponseDTO::new).collect(Collectors.toList());
    }


    public List<GameResponseDTO> getAll() {
        return repository.findAll().stream().map(GameResponseDTO::new).collect(Collectors.toList());
    }
}
