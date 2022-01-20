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
    public int getNumberOfAliveNeighborsInRow(CellState[][] state, int row, int col) {
        int numberOfAliveNeighbor = 0;
        if (row >= 0 && row < state.length) {
            numberOfAliveNeighbor += checkCellIsAlive(state, row, col - 1);
            numberOfAliveNeighbor += checkCellIsAlive(state, row, col);
            numberOfAliveNeighbor += checkCellIsAlive(state, row, col + 1);
        }
        return numberOfAliveNeighbor;
    }
    public int getNumberOfAliveNeighbors(CellState[][] state, int row, int col) {
        int numberOfAliveNeighbor = 0;
        numberOfAliveNeighbor += getNumberOfAliveNeighborsInRow(state, row - 1, col);
        numberOfAliveNeighbor += checkCellIsAlive(state, row, col - 1);
        numberOfAliveNeighbor += checkCellIsAlive(state, row, col + 1);
        numberOfAliveNeighbor += getNumberOfAliveNeighborsInRow(state, row + 1, col);
        return numberOfAliveNeighbor;
    }

    public void update() {
        CellState[][] cellStates = getState();
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                int numberOfAliveNeighbors = getNumberOfAliveNeighbors(cellStates, row, col);
                cells[row][col].update(numberOfAliveNeighbors);
            }
        }
    }


}
