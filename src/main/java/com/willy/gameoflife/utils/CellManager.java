package com.willy.gameoflife.utils;

import com.willy.gameoflife.models.Cell;
import com.willy.gameoflife.models.State;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CellManager {

    private Set<Cell> cells;
    private int minX = Integer.MAX_VALUE;
    private int maxX = Integer.MIN_VALUE;
    private int minY = Integer.MAX_VALUE;
    private int maxY = Integer.MIN_VALUE;

    public CellManager(Set<Cell> cells) {
        this.cells = cells;
    }

    public void computeBounds() {
        cells.forEach(cell -> {
            minX = Math.min(minX, cell.getX());
            maxX = Math.max(maxX, cell.getX());
            minY = Math.min(minY, cell.getY());
            maxY = Math.max(maxY, cell.getY());
        });
    }

    public void displayCells() {
        for (int x = minX - 1; x <= maxX + 1; x++) {
            for (int y = minY - 1; y <= maxY + 1; y++) {
                var state = cells.contains(new Cell(x, y)) ? State.ALIVE : State.DEAD;
                System.out.print(state.label + " ");
            }
            System.out.println();
        }
    }

    public void updateCells() {
        Map<Cell, Integer> neighborCount = new HashMap<>();
        Map<Cell, Boolean> neighborState = new HashMap<>();
        cells.forEach(cell ->
            cell.getNeighbors().forEach(n -> {
                neighborCount.merge(n, 1, Integer::sum);
                neighborState.put(n, cells.contains(n));
            })
        );
        cells.clear();
        neighborCount.forEach((cell, ctr) -> {
            State state = neighborState.get(cell) ? State.ALIVE : State.DEAD;
            if (cell.aliveNextGen(state, ctr)) {
                cells.add(cell);
            }
        });
    }
}
