package com.bootcamp.gameoflife;

import java.io.FileNotFoundException;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

public class GridGeneratorTest {

  private static final String FILE = "src/main/java/assets/glider.txt";

  @Test
  public void testGenerateGridReturnsGrid() throws FileNotFoundException {
    Grid grid = GridGenerator.generateGrid(FILE);

    int rows = 5;
    int cols = 6;
    Set<Cell> cells = Set.of(
        new Cell(0, 1),
        new Cell(1, 2),
        new Cell(2, 0),
        new Cell(2, 1),
        new Cell(2, 2)
    );

    Assert.assertEquals(grid.getCells(), cells);
    Assert.assertEquals(grid.getRows(), rows);
    Assert.assertEquals(grid.getCols(), cols);
  }
}
