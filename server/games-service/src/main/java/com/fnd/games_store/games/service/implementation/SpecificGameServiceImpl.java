package com.fnd.games_store.games.service.implementation;

import com.fnd.games_store.games.dto.game.GameResponseDTO;
import com.fnd.games_store.games.exceptions.GameNotFoundException;
import com.fnd.games_store.games.repository.GameRepository;
import com.fnd.games_store.games.service.SpecificGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SpecificGameServiceImpl implements SpecificGameService {


    private final GameRepository repository;

    @Autowired
    public SpecificGameServiceImpl(GameRepository repository) {
        this.repository = repository;
    }

    @Override
    public GameResponseDTO getGameByName(String name) {
        return new GameResponseDTO(repository.getGameByName(name).orElseThrow(GameNotFoundException::new));
    }
}
