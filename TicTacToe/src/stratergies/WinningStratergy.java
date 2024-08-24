package stratergies;

import models.Board;
import models.Move;

public interface WinningStratergy {
    public boolean checkWinner(Board board , Move move);

    public void handleUndo(Board board , Move move);

}
