import com.example.gameoflife2.Grid;
import com.example.gameoflife2.GridCell.CellState;
import org.junit.Test;

import static org.junit.Assert.*;

public class testGrid {
    private static final CellState O = CellState.DEAD;
    private static final CellState X = CellState.ALIVE;

    @Test
    public void shouldStoreItsInitialState(){
        CellState[][] original = new CellState[][] {
                { X, O, X },
                { O, O, O },
                { O, X, X },
        };
        Grid uut = new Grid(original);

        CellState[][] actual = uut.getState();
        assertArrayEquals(original, actual);
    }


    @Test
    public void checkCellIsAlive () {
        CellState[][] original = new CellState[][] {
                { X, O, X },
                { O, O, O },
                { O, X, X },
        };
        Grid uut = new Grid(original);

        int state= uut.checkCellIsAlive(uut.getState(),0,0);

assertEquals(state,1);

    }



    @Test
    public void getNumberOfAliveNeighborsInRowIfItsValueIsTrue () {
        CellState[][] original = new CellState[][] {
                { X, O, X },
                { O, O, O },
                { O, X, X },
        };
        Grid uut = new Grid(original);

        int state= uut.getNumberOfAliveNeighborsInRow(uut.getState(),0,0);

        assertEquals(state,1);

    }

    @Test
    public void getNumberOfAliveNeighborsInRowIfItsDeadAndHasDeadNeighbor() {
        CellState[][] original = new CellState[][] {
                { X, O, X },
                { O, O, O },
                { O, X, X },
        };
        Grid uut = new Grid(original);

        int state= uut.getNumberOfAliveNeighborsInRow(uut.getState(),1,1);

        assertEquals(state,0);

    }


    @Test
    public void getNumberOfAliveNeighborsToTheCenterCell() {
        CellState[][] original = new CellState[][] {
                { X, O, X },
                { O, O, O },
                { O, X, X },
        };
        Grid uut = new Grid(original);

        int state= uut.getNumberOfAliveNeighbors(uut.getState(),1,1);

        assertEquals(state,4);

    }

    @Test
    public void getNumberOfAliveNeighborsTopLeftCell() {
        CellState[][] original = new CellState[][] {
                { X, O, X },
                { O, O, O },
                { O, X, X },
        };
        Grid uut = new Grid(original);

        int state= uut.getNumberOfAliveNeighbors(uut.getState(),0,0);

        assertEquals(state,0);

    }


    @Test
    public void shouldUpdateCell() {
        Grid uut = new Grid(new CellState[][] { { X } });

        CellState[][] actual = getNextState(uut);

        assertEquals(CellState.DEAD, actual[0][0]);
    }

    @Test
    public void shouldUpdateAllCells() {
        Grid uut = new Grid(new CellState[][] {
                { O, X, X },
                { X, O, X },
                { O, O, X }
        });
        CellState[][] expected = new CellState[][] {
                { O, X, X },
                { O, O, X },
                { O, X, O }
        };

        CellState[][] actual = getNextState(uut);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldConsiderAllNeighbors() {
        Grid uut = new Grid(new CellState[][] {
                { X, X, X },
                { X, X, X },
                { X, X, X }
        });
        CellState[][] expected = new CellState[][] {
                { X, O, X },
                { O, O, O },
                { X, O, X }
        };

        CellState[][] actual = getNextState(uut);

        assertArrayEquals(expected, actual);
    }


    private CellState[][] getNextState(Grid uut) {
        uut.update();
        return uut.getState();
    }

}
