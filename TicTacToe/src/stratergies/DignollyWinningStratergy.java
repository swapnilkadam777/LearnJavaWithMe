package stratergies;

import models.Board;
import models.Move;
import models.Symbol;
import stratergies.WinningStratergy;

import java.util.HashMap;

public class DignollyWinningStratergy implements WinningStratergy {
    HashMap<Integer, HashMap<Symbol, Integer>> counts = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int topToBottom = 0;
        int bottomToTop = 0;
        for (int i = 0; i < board.getSize(); i++) {
            if(move.getPlayer().getSymbol() == board.getGrid().get(i).get(i).getSymbol()){
                topToBottom++;
            }
            if(move.getPlayer().getSymbol() == board.getGrid().get(board.getSize()-i-1).get(i).getSymbol()){
                bottomToTop++;
            }
        }
        if(topToBottom == board.getSize() || bottomToTop == board.getSize()){
            return true;
        }
        return false;
    }
    @Override
    public void handleUndo(Board board, Move move) {
        int c = move.getCeil().getCol();
        Symbol symbol = move.getPlayer().getSymbol();
        counts.get(c).put(symbol, counts.get(c).get(symbol) - 1);
    }
}
