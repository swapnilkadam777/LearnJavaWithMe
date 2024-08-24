import controllers.GameController;
import models.*;
import stratergies.ColWinningStratergy;
import stratergies.DignollyWinningStratergy;
import stratergies.RowWinningStratergy;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        List<Player> players = new ArrayList<>();
        //added hardcoded list of players
        players.add(new HumanPlayer(1,"Swapnil",new Symbol('O'), PlayerType.HUMAN));
        players.add(new HumanPlayer(2,"Sagar",new Symbol('X'),PlayerType.HUMAN));
        Game game = gameController.startGame(3,players,List.of(new RowWinningStratergy(), new ColWinningStratergy(),new DignollyWinningStratergy()));
        while (gameController.gameState(game).equals(GameState.IN_PROGRESS)){
            gameController.displayBoard(game);
            gameController.askForUndoMove(game);
            gameController.makeMove(game);
        }
        if(gameController.gameState(game).equals(GameState.COMPLETED)){
            gameController.displayBoard(game);
            System.out.println(gameController.getWinner(game).getName()+" You Win!");
        } else if (gameController.gameState(game).equals(GameState.DRAW)) {
            System.out.println("This Game is Draw");
        }else{
            System.out.println("Something went wrong");
        }
    }
}
