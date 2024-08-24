package models;
public class Ceil {
    private int row;
    private int col;
    private Symbol symbol;
    private CeilState ceilState;

    public Ceil(int row, int col) {
        this.row = row;
        this.col = col;
        this.symbol = null;
        this.ceilState = CeilState.EMPTY;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public void setCeilState(CeilState ceilState) {
        this.ceilState = ceilState;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public CeilState getCeilState() {
        return ceilState;
    }

    public Symbol getSymbol() {
        return symbol;
    }
    public void displayCell(){
        // either the cell can be empty
        if(ceilState == ceilState.EMPTY){
            System.out.print("[ - ]");
        } else {
            System.out.print("[ " + symbol.getSym() + " ]");
        }
    }
}
