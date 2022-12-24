package com.fnd.games_store.games.service.implementation;

import com.fnd.games_store.games.dto.GameResponseDTO;
import com.fnd.games_store.games.repository.GameJpaRepository;
import com.fnd.games_store.games.repository.GamePagingAndSortingRepository;
import com.fnd.games_store.games.service.GamePagingAndSortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GamePagingAndSortingServiceImpl implements GamePagingAndSortingService {


    private final GameJpaRepository jpaRepository;

    private final GamePagingAndSortingRepository pagingAndSortingRepository;
    @Autowired
    public GamePagingAndSortingServiceImpl(GameJpaRepository jpaRepository, GamePagingAndSortingRepository pagingAndSortingRepository) {
        this.jpaRepository = jpaRepository;
        this.pagingAndSortingRepository = pagingAndSortingRepository;
    }


    @Override
    public GameResponseDTO getSpecifiedGameList() {
        return null;
    }

    @Override
    public List<GameResponseDTO> getAll() {
        return jpaRepository.findAll().stream().map(GameResponseDTO::new).collect(Collectors.toList());
    }
}
