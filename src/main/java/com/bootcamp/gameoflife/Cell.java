package com.bootcamp.gameoflife;

import java.util.Objects;

public class Cell {

  private int row;
  private int col;

  public Cell(int row, int col) {
    this.row = row;
    this.col = col;
  }

  public int getRow() {
    return row;
  }

  public int getCol() {
    return col;
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
    return getRow() == cell.getRow() && getCol() == cell.getCol();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getRow(), getCol());
  }
}
