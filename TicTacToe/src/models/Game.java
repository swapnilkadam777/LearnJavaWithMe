package models;

import stratergies.WinningStratergy;

import java.util.*;

public class Game {
    private Board board;
    private List<Player> players;
    private int nextPlayerIndex;
    private Player winner;
    private List<Move> moves;
    private GameState gameState;
    private List<WinningStratergy> winningStratergies;

    private Scanner sc = new Scanner(System.in);
    public Game(Builder builder) {
        board = new Board(builder.dimention);
        this.players = builder.players;
        this.nextPlayerIndex = 0;
        this.winner = null;
        this.moves = new ArrayList<>() ;
        this.gameState = GameState.IN_PROGRESS;
        this.winningStratergies = builder.winningStratergies;
    }

    public Board getBoard() {
        return board;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public Player getWinner() {
        return winner;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public GameState getGameState() {
        return gameState;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public void display() {
        board.displayBoard();
    }

    public void askForUndoMove() {
        int totalMoves = moves.size();
        if(totalMoves>0){
            System.out.println("Do you want to Undo your move.If yes then type 1 other wise type N");
            String undo = sc.next();
            if(undo.equalsIgnoreCase("N")){
                return;
            }else if(undo.equalsIgnoreCase("Y")){
                moves.remove(totalMoves-1);
                nextPlayerIndex++;
                nextPlayerIndex %= players.size();
            }else{
                System.out.println("Please enter correct input");
                this.askForUndoMove();
            }
        }

    }
    public boolean validateMove(Move move){
        int r = move.getCeil().getRow();
        int c = move.getCeil().getCol();

        if(r < 0 || r > board.getSize() - 1 || c < 0 || c > board.getSize() - 1){
            return false;
        }

        // we also need to check if Cell is not already filled
        return board.getGrid().get(r).get(c).getCeilState().equals(CeilState.EMPTY);
    }
    public void makeMove() {
        Player currentPlayer = players.get(nextPlayerIndex);
        System.out.println("Hey "+currentPlayer.getName()+" It's your turn! Please make your move");
        Move move = currentPlayer.makeMove(board);
        if (!validateMove(move)) {
            System.out.println("Invalid Move! Please try again");
            return;
        }
        int r = move.getCeil().getRow();
        int c = move.getCeil().getCol();
        Ceil cellToChange = board.getGrid().get(r).get(c);
        cellToChange.setSymbol(currentPlayer.getSymbol());
        cellToChange.setCeilState(CeilState.FILLED);
        move.setCeil(cellToChange);
        moves.add(move);
        nextPlayerIndex++;
        nextPlayerIndex %= players.size();

        if(checkWinner(move)){
            setWinner(currentPlayer);
            setGameState(GameState.COMPLETED);
        } else if (moves.size() ==  board.getSize() * board.getSize()){
            setWinner(null);
            setGameState(GameState.DRAW);
        }
    }
    public boolean checkWinner(Move move){
        // we should go through winning strategies available and check if any of
        // those produces a winner
        for(WinningStratergy winningStrategy : winningStratergies){
            if(winningStrategy.checkWinner(this.board , move)){
                return true;
            }
        }
        return false;
    }
    public static class Builder{
        private int dimention;
        private List<Player> players;
        private List<WinningStratergy> winningStratergies;
        public Builder setDimention(int dimention) {
            this.dimention = dimention;
            return this;
        }
        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }
        public Builder setWinningStratergies(List<WinningStratergy> winningStratergies) {
            this.winningStratergies = winningStratergies;
            return this;
        }
        public void validate() {
            // check validation grid dimentions and players
            if (players.size() != dimention - 1) {
                throw new RuntimeException("Incorrect number of players");
            }
            //        Bot count <=1
            int botCount= 0;
            Set<Symbol> hashSet = new HashSet<>();
            for (Player player:players){
                if(player.getPlayerType().equals(PlayerType.BOT)){
                    botCount+=1;
                }
                hashSet.add(player.getSymbol());
            }
            if(botCount>1){
                throw new RuntimeException("Too Many Bot Players");
            }
            if(players.size() > 0 && players.size() != hashSet.size()){
                throw new RuntimeException("Please make sure every player has different symbol");
            }
            //        Every Player Symbol Different
        }
        public Game build(){
//            validate();
            return new Game(this);
        }
    }
}
