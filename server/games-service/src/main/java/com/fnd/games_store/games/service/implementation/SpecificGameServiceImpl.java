package com.fnd.games_store.games.service.implementation;

import com.fnd.games_store.games.annotations.Benchmarked;
import com.fnd.games_store.games.dto.game.GameResponseDTO;
import com.fnd.games_store.games.exceptions.GameNotFoundException;
import com.fnd.games_store.games.repository.GameRepository;
import com.fnd.games_store.games.service.SpecificGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SpecificGameServiceImpl implements SpecificGameService {


    private final GameRepository repository;

    @Autowired
    public SpecificGameServiceImpl(GameRepository repository) {
        this.repository = repository;
    }

    @Transactional(label = "specific_gameList_fetch",
            propagation = Propagation.REQUIRED,
            isolation = Isolation.REPEATABLE_READ,
            timeout = 5,
            readOnly = true,
            rollbackFor = GameNotFoundException.class)
    @Benchmarked
    @Override
    public GameResponseDTO getGameByName(String name) {
        return new GameResponseDTO(repository.getGameByName(name).orElseThrow(GameNotFoundException::new));
    }
}
