package models;

import java.util.Scanner;

public class Player {
    private long id;
    private String name;
    private Symbol symbol;
    private PlayerType playerType;
    private Scanner sc = new Scanner(System.in);
    public Player(long id, String name, Symbol symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }
    public Move makeMove(Board board) {
        System.out.println("Please enter the row in which you want to move");
        int r = sc.nextInt();
        System.out.println("Please enter the col in which you want to move");
        int c = sc.nextInt();

        return new Move(new Ceil(r ,c) , this);
    }
}
