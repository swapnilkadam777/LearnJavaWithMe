package stratergies;

import models.Board;
import models.Move;
import models.Symbol;
import stratergies.WinningStratergy;

import java.util.HashMap;

public class RowWinningStratergy implements WinningStratergy {
    HashMap<Integer, HashMap<Symbol, Integer>> counts = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        // O(1)
        // 0 -> {{"X" , 2}, {"O" , 1}}
        int r = move.getCeil().getRow();
        Symbol symbol = move.getCeil().getSymbol();

        if(!counts.containsKey(r)){
            counts.put(r, new HashMap<>());
        }

        HashMap<Symbol, Integer> countRow = counts.get(r);

        if(!countRow.containsKey(symbol)){
            countRow.put(symbol, 0);
        }
        countRow.put(symbol, countRow.get(symbol) + 1);
        return  countRow.get(symbol) == board.getSize();
    }
    @Override
    public void handleUndo(Board board, Move move) {
        int c = move.getCeil().getCol();
        Symbol symbol = move.getPlayer().getSymbol();
        counts.get(c).put(symbol, counts.get(c).get(symbol) - 1);
    }
}
