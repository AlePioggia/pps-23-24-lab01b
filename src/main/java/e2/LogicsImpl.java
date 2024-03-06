package e2;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import e2.model.Cell;
import e2.model.Grid;
import e2.model.GridConstants;
import e2.model.GridImpl;

public class LogicsImpl implements Logics {

    private final Grid grid;
    private final Set<Cell> flags;

    public LogicsImpl() {
        this.grid = new GridImpl();
        this.flags = new HashSet<>();
    }

    @Override
    public Grid getGrid() {
        return this.grid;
    }

    @Override
    public boolean isWin() {
        int totalCells = GridConstants.SIZE.getValue() * GridConstants.SIZE.getValue();
        int safeCells = totalCells - this.grid.getBombsTotal();
        return this.grid.getVisitedCellsSet().size() == safeCells;
    }

    @Override
    public void performAutoClicks(Cell cell) {
        Collection<Cell> adjacentCells = this.grid.getAdjacentCells(cell);
        adjacentCells.stream()
                .filter(adjacentCell -> !this.grid.isBomb(adjacentCell)
                        && !this.grid.isCellAlreadyVisited(adjacentCell))
                .forEach(adjacentCell -> {
                    this.grid.updateVisitedCellsSet(adjacentCell);
                    if (this.grid.getAdjancentBombsTotal(adjacentCell) == 0) {
                        performAutoClicks(adjacentCell);
                    }
                });
    }

    @Override
    public boolean hasFlag(Cell cell) {
        return this.flags.contains(cell);
    }

    @Override
    public void toggleFlag(Cell cell) {
        if (flags.contains(cell)) {
            this.flags.remove(cell);
        } else {
            this.flags.add(cell);
        }
    }

}
