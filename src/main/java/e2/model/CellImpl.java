package e2.model;

import e1.Pair;

public class CellImpl implements Cell {

    private final Pair<Integer, Integer> position;

    public CellImpl(int x, int y) {
        this.position = new Pair<>(x, y);
    }

    @Override
    public int getX() {
        return this.position.getX();
    }

    @Override
    public int getY() {
        return this.position.getY();
    }

    @Override
    public Pair<Integer, Integer> getCell() {
        return this.position;
    }

    @Override
    public boolean isAdjacentTo(int x, int y) {
        return computeAdjacency(x, y);
    }

    @Override
    public boolean isAdjacentTo(Cell cell) {
        return computeAdjacency(cell.getX(), cell.getY());
    }

    private boolean computeAdjacency(int row, int col) {
        int x = Math.abs(this.getX() - row);
        int y = Math.abs(this.getY() - col);
        return !(x == 0 && y == 0) && x <= 1 && y <= 1;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((position == null) ? 0 : position.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CellImpl other = (CellImpl) obj;
        if (position == null) {
            if (other.position != null)
                return false;
        } else if (!position.equals(other.position))
            return false;
        return true;
    }
}
