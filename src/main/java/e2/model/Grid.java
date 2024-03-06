package e2.model;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface Grid {
    /**
     * 
     * @param cell
     * @return bombs count, based on adjancy
     */
    int getAdjancentBombsTotal(Cell cell);

    /**
     * 
     * @return the list of already visited cells
     */
    Set<Cell> getVisitedCellsSet();

    /**
     * updates the selected's cells list
     * 
     * @param cell
     */
    void updateVisitedCellsSet(Cell cell);

    /**
     * Checks whenever a cell was already visited
     */
    boolean isCellAlreadyVisited(Cell cell);

    /**
     * Checks if a cell contains a bomb
     * 
     * @param cell
     * @return
     */
    boolean isBomb(Cell cell);

    /**
     * 
     * @param cell
     * @return
     */
    Collection<Cell> getAdjacentCells(Cell cell);

    /**
     * 
     * @return total bombs count
     */
    int getBombsTotal();

    /**
     * 
     * @return cells map
     */
    Map<Cell, Boolean> cells();

}
