package com.example.gameoflife2;
import com.example.gameoflife2.GridCell.CellState;


public class Grid {

    private GridCell[][] cells;

    public Grid(GridCell.CellState[][] cellStates) {
        cells = new GridCell[cellStates.length][];
        for (int row = 0; row < cellStates.length; row++) {
            cells[row] = new GridCell[cellStates[row].length];
            for (int col = 0; col < cellStates[row].length; col++) {
                cells[row][col] = new GridCell(cellStates[row][col]);
            }
        }
    }
    public CellState[][] getState() {
        CellState[][] cellStates = new CellState[cells.length][];
        for (int row = 0; row < cells.length; row++) {
            cellStates[row] = new CellState[cells[row].length];
            for (int col = 0; col < cells[row].length; col++) {
                cellStates[row][col] = cells[row][col].getState();
            }
        }
        return cellStates;
    }


    public int checkCellIsAlive(CellState[][] state, int row, int col) {
        if (col >= 0 && col < state[row].length) {
            if (state[row][col] == CellState.ALIVE) {
                return 1;
            }
        }
        return 0;
    }

}
