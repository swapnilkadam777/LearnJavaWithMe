package models;
public class HumanPlayer extends Player{
    public HumanPlayer(long id, String name, Symbol symbol, PlayerType playerType) {
        super(id, name, symbol, playerType);
        this.setPlayerType(PlayerType.HUMAN);
    }
}
