package com.willy.gameoflife.models;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cell {

    private static final int[][] NEIGHBOR_OFFSETS = {
        {1, 1}, {1, -1}, {-1, -1}, {-1, 1}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    private final int x;
    private final int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean aliveNextGen(State state, int neighbors) {
        if (state == State.ALIVE) {
            return neighbors == 3 || neighbors == 2;
        } else {
            return neighbors == 3;
        }
    }

    public List<Cell> getNeighbors() {
        return Arrays.stream(NEIGHBOR_OFFSETS)
            .map(n -> new Cell(x + n[0], y + n[1]))
            .collect(Collectors.toList());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cell)) {
            return false;
        }
        Cell cell = (Cell) o;
        return x == cell.x && y == cell.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
