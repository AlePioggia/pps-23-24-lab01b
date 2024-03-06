package e1.ChessPiece;

import e1.Pair;

public interface ChessPiece {
    /**
     * 
     * @return current chess piece position
     */
    Pair<Integer, Integer> getPosition();

    /**
     * 
     * @param destination
     * @return true if position has changed
     */
    boolean move(int row, int col);
}
