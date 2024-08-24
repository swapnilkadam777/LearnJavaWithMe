package models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Ceil>> grid;

    public Board(int size) {
        this.size = size;
        this.grid = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            grid.add(new ArrayList<>());
            for (int j = 0; j < size; j++) {
                grid.get(i).add(new Ceil(i,j));
            }
        }
    }

    public int getSize() {
        return size;
    }

    public List<List<Ceil>> getGrid() {
        return grid;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setGrid(List<List<Ceil>> grid) {
        this.grid = grid;
    }
    public void displayBoard(){
        for(List<Ceil> row : grid){
            for(Ceil cell : row){
                cell.displayCell();
            }
            System.out.println();
        }
    }
}
