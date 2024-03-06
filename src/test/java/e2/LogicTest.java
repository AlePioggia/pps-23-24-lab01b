package e2;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import e2.model.Cell;
import e2.model.CellImpl;
import e2.model.Grid;
import e2.model.GridConstants;

public class LogicTest {
    private Logics logics;

    @BeforeEach
    public void setUp() {
        logics = new LogicsImpl();
    }

    @Test
    public void testIsWin() {
        Grid grid = logics.getGrid();
        for (int i = 0; i < GridConstants.SIZE.getValue(); i++) {
            for (int j = 0; j < GridConstants.SIZE.getValue(); j++) {
                Cell cell = new CellImpl(i, j);
                if (!grid.isBomb(cell)) {
                    grid.updateVisitedCellsSet(cell);
                }
            }
        }

        assertTrue(logics.isWin());
    }

    @Test
    public void testPerformAutoClicks() {
        Grid grid = logics.getGrid();
        Cell emptyCell = new CellImpl(0, 0);
        grid.cells().put(emptyCell, false);
        grid.cells().put(new CellImpl(0, 1), false);
        grid.cells().put(new CellImpl(1, 0), false);

        this.logics.performAutoClicks(emptyCell);

        assertTrue(grid.isCellAlreadyVisited(emptyCell));
        assertTrue(grid.isCellAlreadyVisited(new CellImpl(0, 1)));
        assertTrue(grid.isCellAlreadyVisited(new CellImpl(1, 0)));
    }

}
