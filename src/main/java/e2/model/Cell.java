package e2.model;

import e1.Pair;

public interface Cell {
    /**
     * 
     * @return cell's x coordinate
     */
    int getX();

    /**
     * 
     * @return cell's y coordinate
     */
    int getY();

    /**
     * 
     * @return cell
     */
    Pair<Integer, Integer> getCell();

    /**
     * Measures the adj. with coordinates
     * 
     * @param x
     * @param y
     * @return
     */
    boolean isAdjacentTo(int x, int y);

    /**
     * Measures the adj. with cell
     * 
     * @param cell
     * @return
     */
    boolean isAdjacentTo(Cell cell);
}
