package e1.ChessPiece;

import e1.Pair;

public class Knight extends AbstractChessPiece {

    public Knight(Pair<Integer, Integer> position) {
        super(position);
    }

    @Override
    public boolean move(int row, int col) {
        Pair<Integer, Integer> knightPosition = this.getPosition();

        int x = row - knightPosition.getX();
        int y = col - knightPosition.getY();

        if (x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3) {
            this.position = new Pair<Integer, Integer>(row, col);
            return true;
        }
        return false;
    }
}
