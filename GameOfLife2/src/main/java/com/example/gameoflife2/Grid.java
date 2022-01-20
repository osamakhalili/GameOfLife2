package com.example.gameoflife2;

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

}
