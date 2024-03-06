package e2.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

public class GridImpl implements Grid {

    private final Map<Cell, Boolean> cellsMap;
    private final Set<Cell> exploredCells;

    public GridImpl() {
        this.exploredCells = new HashSet<>();
        this.cellsMap = new HashMap<>();
        this.setupGrid();
        this.addBombsToGrid();
    }

    private void setupGrid() {
        IntStream.range(0, GridConstants.SIZE.getValue())
                .forEach(i -> IntStream.range(0, GridConstants.SIZE.getValue())
                        .forEach(j -> this.cellsMap.put(new CellImpl(i, j), false)));
    }

    private void addBombsToGrid() {
        Random random = new Random();
        random.ints(GridConstants.BOMBS_NUMBER.getValue(), 0,
                GridConstants.SIZE.getValue() * GridConstants.SIZE.getValue())
                .mapToObj(index -> new CellImpl(index / GridConstants.SIZE.getValue(),
                        index % GridConstants.SIZE.getValue()))
                .distinct()
                .forEach(cell -> this.cellsMap.put(cell, true));
    }

    @Override
    public int getAdjancentBombsTotal(Cell cell) {
        return (int) this.cellsMap.entrySet().stream().filter(x -> x.getKey().isAdjacentTo(cell))
                .filter(x -> x.getValue()).count();
    }

    @Override
    public boolean isBomb(Cell cell) {
        Boolean isBomb = this.cellsMap.get(cell);
        return isBomb != null && isBomb;
    }

    @Override
    public Set<Cell> getVisitedCellsSet() {
        return this.exploredCells;
    }

    @Override
    public void updateVisitedCellsSet(Cell cell) {
        this.exploredCells.add(cell);
    }

    @Override
    public boolean isCellAlreadyVisited(Cell cell) {
        return this.exploredCells.contains(cell);
    }

    @Override
    public Collection<Cell> getAdjacentCells(Cell cell) {
        return this.cellsMap.keySet().stream().filter(cell::isAdjacentTo).toList();
    }

    @Override
    public int getBombsTotal() {
        return (int) this.cellsMap.entrySet().stream().filter(x -> x.getValue()).count();
    }

    @Override
    public Map<Cell, Boolean> cells() {
        return this.cellsMap;
    }
}
