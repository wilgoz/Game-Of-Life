package com.bootcamp.gameoflife;

import java.util.Set;

public class Grid {

  private Set<Cell> cells;
  private int rows;
  private int cols;

  public Grid(Set<Cell> cells, int rows, int cols) {
    this.cells = cells;
    this.rows = rows;
    this.cols = cols;
  }

  public Set<Cell> getCells() {
    return cells;
  }

  public int getRows() {
    return rows;
  }

  public int getCols() {
    return cols;
  }
}
