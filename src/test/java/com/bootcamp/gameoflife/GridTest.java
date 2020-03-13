package com.bootcamp.gameoflife;

import java.util.Set;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GridTest {

  private Set<Cell> cells;
  private Grid grid;
  private int rows;
  private int cols;

  @Before
  public void setUpGrid() {
    cells = Set.of(
        new Cell(0, 0),
        new Cell(0, 1)
    );
    rows = 2;
    cols = 2;
    grid = new Grid(cells, rows, cols);
  }

  @Test
  public void testGetCellsReturnsCells() {
    Assert.assertEquals(cells, grid.getCells());
  }

  @Test
  public void testGetRowsReturnsRows() {
    Assert.assertEquals(rows, grid.getRows());
  }

  @Test
  public void testGetColsReturnsCols() {
    Assert.assertEquals(cols, grid.getCols());
  }
}
