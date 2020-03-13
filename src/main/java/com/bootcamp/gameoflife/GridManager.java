package com.bootcamp.gameoflife;

import java.util.Set;

public class GridManager {

  private Set<Cell> cells;
  private int rows;
  private int cols;

  public GridManager(Grid grid) {
    cells = grid.getCells();
    rows = grid.getRows();
    cols = grid.getCols();
  }

  public void displayGrid() {
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        var state = cells.contains(new Cell(row, col)) ? State.ALIVE : State.DEAD;
        System.out.print(state.label + " ");
      }
      System.out.println();
    }
  }
}
