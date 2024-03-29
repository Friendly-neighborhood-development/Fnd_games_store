package com.fnd.games_store.games.service.implementation;



import com.fnd.games_store.games.service.GameCatalogueEditorService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GameCatalogueEditorServiceImpl implements GameCatalogueEditorService {

//    private final GameJpaRepository gameJpaRepository;
//
//    @Autowired
//    public GameService(GameJpaRepository gameJpaRepository) {
//        this.gameJpaRepository = gameJpaRepository;
//    }
//
//    public GameResponseDTO getGameById(String requestedGameId){
//        Game foundGameById = gameJpaRepository.findById(requestedGameId).orElseThrow(GameNotFoundException::new);
//        return new GameResponseDTO(foundGameById);
//    }
//
//   public List<GameResponseDTO> getGamesCatalogue(){
//        return gameJpaRepository.findAll().stream().map(GameResponseDTO::new).collect(Collectors.toList());
//    }
//
//   public GameResponseDTO createGameEntry(GameRequestDTO creatingGameBody) {
//        Game gameFound = gameJpaRepository.getGameByName(creatingGameBody.getName());
//        if (gameFound != null ){
//            throw new GameAlreadyExistException("This game entry already exist in database");
//        } else {
//            Game creatingGameEntry = new Game(creatingGameBody.getName(), creatingGameBody.getGenre(), creatingGameBody.getReleaseDate(),
//                    creatingGameBody.getDeveloper(), creatingGameBody.getPublisher(), creatingGameBody.getPlatform(),
//                    creatingGameBody.getFeatures(),creatingGameBody.getPrice(), creatingGameBody.getDiscount(),
//                    creatingGameBody.getDescription(), creatingGameBody.getBase64Image());
//            return new GameResponseDTO(gameJpaRepository.save(creatingGameEntry));
//        }
//
//    }
//
//    public GameResponseDTO updateGameEntry(String updatingGameId, GameRequestDTO newGameBody) {
//            gameJpaRepository.findById(updatingGameId).orElseThrow(GameNotFoundException::new);
//            Game updatingGameEntry = new Game(newGameBody.getName(), newGameBody.getGenre(), newGameBody.getReleaseDate(),
//                                              newGameBody.getDeveloper(), newGameBody.getPublisher(), newGameBody.getPlatform(),
//                                              newGameBody.getFeatures(),newGameBody.getPrice(), newGameBody.getDiscount(),
//                                              newGameBody.getDescription(), newGameBody.getBase64Image());
//            updatingGameEntry.setId(updatingGameId);
//            return new GameResponseDTO(gameJpaRepository.save(updatingGameEntry));
//    }
//
//        public void deleteGameEntry(String deletingGameId){
//        gameJpaRepository.deleteById(deletingGameId);
//    }

}
