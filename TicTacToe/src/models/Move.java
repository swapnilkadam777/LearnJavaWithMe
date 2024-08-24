package models;
public class Move {
    private Ceil ceil;
    private Player player;

    public Move(Ceil ceil, Player player) {
        this.ceil = ceil;
        this.player = player;
    }

    public void setCeil(Ceil ceil) {
        this.ceil = ceil;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Ceil getCeil() {
        return ceil;
    }

    public Player getPlayer() {
        return player;
    }
}
