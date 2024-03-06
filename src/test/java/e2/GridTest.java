package e2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import e2.model.Cell;
import e2.model.CellImpl;
import e2.model.Grid;
import e2.model.GridImpl;

public class GridTest {

    private Grid grid;

    @BeforeEach
    public void setUp() {
        grid = new GridImpl();
    }

    @Test
    public void testIsBomb() {
        Cell bombCell = new CellImpl(0, 0);
        grid.cells().put(bombCell, true);

        assertTrue(grid.isBomb(bombCell));
    }

    @Test
    public void testGetAdjancentBombsTotal() {
        Cell cell = new CellImpl(0, 0);
        grid.cells().put(new CellImpl(0, 1), true);
        grid.cells().put(new CellImpl(1, 0), true);
        grid.cells().put(new CellImpl(1, 1), true);

        assertEquals(grid.getAdjancentBombsTotal(cell), 3);
    }

    @Test
    public void testIsCellAlreadyVisited() {
        Cell visitedCell = new CellImpl(0, 0);
        grid.updateVisitedCellsSet(visitedCell);

        assertTrue(grid.isCellAlreadyVisited(visitedCell));
    }

    @Test
    public void testGetAdjacentCells() {
        Cell centerCell = new CellImpl(1, 1);
        iterate(2, 2);

        assertEquals(8, grid.getAdjacentCells(centerCell).size());
    }

    private void iterate(int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grid.cells().put(new CellImpl(i, j), false);
            }
        }
    }

}
