package com.example.gameoflife2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class AppController {
    private static final GridCell.CellState O = GridCell.CellState.DEAD;
    private static final GridCell.CellState X = GridCell.CellState.ALIVE;

    @FXML
    GridPane gridPane;
    Grid grid ;
    public AppController() {
        GridCell.CellState[][] original = new GridCell.CellState[][]{
                {X, O, X, X, O, X, X, O},
                {O, O, O, X, X, O, X, O},
                {O, X, X, O, X, O, X, X},
                {X, O, X, O, O, O, O, X},
        };
        grid = new Grid(original);
        gridPane = new GridPane();
        setGridPane(grid.getCells());
    }

    public void setGridPane(GridCell[][] state ) {
        this.gridPane.getChildren().clear();
        for (int row = 0; row < state.length; row++) {
            for (int col = 0; col < state[row].length; col++) {

                Rectangle rect = new Rectangle(75,75);
                if(state[row][col].getState()== GridCell.CellState.ALIVE){
                    rect.setFill(Color.GHOSTWHITE);
                }else{
                    rect.setFill(Color.BLACK);
                }
                gridPane.add(rect,row,col);
            }
        }
    }
    public void onGenerateClick(){
        grid.update();
        setGridPane(grid.getCells());
    }
}