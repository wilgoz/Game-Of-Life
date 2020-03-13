package com.willy.gameoflife;

import org.junit.Assert;
import org.junit.Test;

public class CellTest {

    @Test
    public void testGetRowReturnGivenRow() {
        Cell cell = new Cell(2, 1);
        Assert.assertEquals(2, cell.getRow());
    }

    @Test
    public void testGetColReturnGivenCol() {
        Cell cell = new Cell(2, 1);
        Assert.assertEquals(1, cell.getCol());
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
}
