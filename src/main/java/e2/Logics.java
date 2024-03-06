package e2;

import e2.model.Cell;
import e2.model.Grid;

public interface Logics {
    /**
     * 
     * @return the entire grid, with bombs
     */
    Grid getGrid();

    /**
     * 
     * @return
     */

    boolean isWin();

    /**
     * it performs autoclicks on empty cells
     * 
     * @param cell
     */
    void performAutoClicks(Cell cell);

    /**
     * 
     * @return true if it's flagged, false otherwise
     */
    boolean hasFlag(Cell cell);

    /**
     * adds flag to a cell
     */
    void toggleFlag(Cell cell);
}
