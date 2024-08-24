package stratergies;

import models.Board;
import models.Move;
import models.Symbol;
import stratergies.WinningStratergy;

import java.util.HashMap;

public class ColWinningStratergy implements WinningStratergy {
    HashMap<Integer, HashMap<Symbol, Integer>> counts = new HashMap<>();
    @Override
    public boolean checkWinner(Board board , Move move) {
        // O(1)
        // 0 -> {"X" , 2}
        // 0 -> {"O" , 0}
        int c = move.getCeil().getCol();
        Symbol symbol = move.getCeil().getSymbol();

        if(!counts.containsKey(c)){
            counts.put(c, new HashMap<>());
        }

        HashMap<Symbol, Integer> countCol = counts.get(c);

        if(!countCol.containsKey(symbol)){
            countCol.put(symbol, 0);
        }
        countCol.put(symbol, countCol.get(symbol) + 1);

        return  countCol.get(symbol) == board.getSize();
    }
    @Override
    public void handleUndo(Board board, Move move) {
        int c = move.getCeil().getCol();
        Symbol symbol = move.getPlayer().getSymbol();
        counts.get(c).put(symbol, counts.get(c).get(symbol) - 1);
    }

}
