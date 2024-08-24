package models;
public class BotPlayer extends Player{
    private BotDifficultyLevel diffLevel;

    public BotPlayer(long id, String name, Symbol symbol, PlayerType playerType, BotDifficultyLevel diffLevel) {
        super(id, name, symbol, playerType);
        this.diffLevel = diffLevel;
        this.setPlayerType(PlayerType.BOT  );
    }

    public void setDiffLevel(BotDifficultyLevel diffLevel) {
        this.diffLevel = diffLevel;
    }

    public BotDifficultyLevel getDiffLevel() {
        return diffLevel;
    }
}
