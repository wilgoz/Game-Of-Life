package com.willy.gameoflife.models;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CellTest {

    @Test
    public void testGetRowReturnGivenRow() {
        Cell cell = new Cell(2, 1);
        Assert.assertEquals(2, cell.getX());
    }

    @Test
    public void testGetColReturnGivenCol() {
        Cell cell = new Cell(2, 1);
        Assert.assertEquals(1, cell.getY());
    }

    @Test
    public void testEqualGivenSameObjectsReturnTrue() {
        Cell cell = new Cell(2, 1);
        Assert.assertEquals(cell, cell);
    }

    @Test
    public void testEqualGivenDiffInstancesReturnFalse() {
        Cell cell = new Cell(2, 1);
        Assert.assertNotEquals(cell, null);
    }

    @Test
    public void testEqualGivenDiffObjectsSameRowsColsReturnTrue() {
        Cell cell1 = new Cell(2, 1);
        Cell cell2 = new Cell(2, 1);
        Assert.assertEquals(cell1, cell2);
    }

    @Test
    public void testEqualGivenDiffObjectsDiffColsReturnFalse() {
        Cell cell1 = new Cell(2, 2);
        Cell cell2 = new Cell(2, 1);
        Assert.assertNotEquals(cell1, cell2);
    }

    @Test
    public void testEqualGivenDiffObjectsDiffRowsReturnFalse() {
        Cell cell1 = new Cell(1, 2);
        Cell cell2 = new Cell(2, 2);
        Assert.assertNotEquals(cell1, cell2);
    }

    @Test
    public void testHashGivenDiffObjectsSameRowsColsReturnSameHash() {
        Cell cell1 = new Cell(2, 2);
        Cell cell2 = new Cell(2, 2);
        Assert.assertEquals(cell1.hashCode(), cell2.hashCode());
    }

    @Test
    public void testGetNeighborsGetCellsIn8Directions() {
        int x = 2;
        int y = 2;
        var neighbors = new HashSet<>(new Cell(x, y).getNeighbors());
        List<Cell> cells = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 || j != 0) {
                    cells.add(new Cell(x + i, y + j));
                }
            }
        }
        Assert.assertTrue(neighbors.containsAll(cells));
    }

    @Test
    public void testAliveNextGenGivenAliveWith3NeighborsReturnsTrue() {
        Assert.assertTrue(new Cell(0, 0).aliveNextGen(State.ALIVE, 3));
    }

    @Test
    public void testAliveNextGenGivenAliveWith2NeighborsReturnsTrue() {
        Assert.assertTrue(new Cell(0, 0).aliveNextGen(State.ALIVE, 2));
    }

    @Test
    public void testAliveNextGenGivenAliveWithLessThan2NeighborsReturnsFalse() {
        Assert.assertFalse(new Cell(0, 0).aliveNextGen(State.ALIVE, 1));
    }

    @Test
    public void testAliveNextGenGivenAliveWithMoreThan3NeighborsReturnsFalse() {
        Assert.assertFalse(new Cell(0, 0).aliveNextGen(State.ALIVE, 4));
    }

    @Test
    public void testAliveNextGenGivenDeadWith3NeighborsReturnsTrue() {
        Assert.assertTrue(new Cell(0, 0).aliveNextGen(State.DEAD, 3));
    }

    @Test
    public void testAliveNextGenGivenDeadWithLessThan3NeighborsReturnsFalse() {
        Assert.assertFalse(new Cell(0, 0).aliveNextGen(State.DEAD, 2));
    }

    @Test
    public void testAliveNextGenGivenDeadWithMoreThan3NeighborsReturnsFalse() {
        Assert.assertFalse(new Cell(0, 0).aliveNextGen(State.DEAD, 4));
    }
}
