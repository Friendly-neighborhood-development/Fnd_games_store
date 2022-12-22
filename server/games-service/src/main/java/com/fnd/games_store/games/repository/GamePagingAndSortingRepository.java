package com.fnd.games_store.games.repository;

import com.fnd.games_store.games.entity.Game;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GamePagingAndSortingRepository extends PagingAndSortingRepository<Game, String> {
}
