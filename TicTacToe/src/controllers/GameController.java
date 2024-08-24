package controllers;

import models.Game;
import models.GameState;
import models.Player;
import stratergies.WinningStratergy;

import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class GameController {
    public Game startGame(int dimention,
                          List<Player> players,
                          List<WinningStratergy> winningStratergies){
        return Game.getBuilder().
                setDimention(dimention).
                setPlayers(players).
                setWinningStratergies(winningStratergies)
                .build();

    }
    public GameState gameState(Game game){
        return game.getGameState();
    }
    public void displayBoard(Game game){
        game.display();
    }
    public void askForUndoMove(Game game){
            game.askForUndoMove();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }
}
