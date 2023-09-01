package com.company.gamestore.controller;

import com.company.gamestore.model.Game;
import com.company.gamestore.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class GameController {
    @Autowired
    GameRepository gameRepository;

    // Create
    @PostMapping(path = "/game")
    @ResponseStatus(HttpStatus.CREATED)
    public Game addGame(@RequestBody @Valid Game game) {
        return gameRepository.save(game);
    }

    // Read
    @GetMapping("/game/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Game getGameById(@PathVariable int id) {
        Optional<Game> returnVal = gameRepository.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        }
        return null;
    }

    // Read All
    @GetMapping("/game")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    // Update
    @PutMapping(path = "/game")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Game updateGame(@RequestBody @Valid Game game) {
        return gameRepository.save(game);
    }

    // Delete
    @DeleteMapping("/game/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGameById(@PathVariable int id) {
        gameRepository.deleteById(id);
    }

    // Find By Studio
    @GetMapping("/game/studio/{studio}")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> findGamesByStudio(@PathVariable String studio) {
        return gameRepository.findByStudio(studio);
    }

    // Find By ESRB
    @GetMapping("/game/esrbrating/{esrbRating}")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> findGamesByEsrbRating(@PathVariable String esrbRating) {
        return gameRepository.findByEsrbRating(esrbRating);
    }

    // Find By Title
    @GetMapping("/game/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> findGamesByTitle(@PathVariable String title) {
        return gameRepository.findByTitle(title);
    }

}
