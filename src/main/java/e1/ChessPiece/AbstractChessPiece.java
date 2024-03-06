package e1.ChessPiece;

import e1.Pair;

public abstract class AbstractChessPiece implements ChessPiece {

    protected Pair<Integer, Integer> position;

    public AbstractChessPiece(Pair<Integer, Integer> position) {
        this.position = position;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }

    @Override
    public boolean move(int row, int col) {
        this.position = new Pair<>(row, col);
        return this.position.equals(new Pair<>(row, col));
    }

}
