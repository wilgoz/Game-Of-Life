package com.bootcamp.gameoflife;

import java.io.FileNotFoundException;

public class GameOfLife {

  private GridManager gridManager;
  private double iterations;

  public GameOfLife(String path, double iterations) throws FileNotFoundException {
    this.iterations = iterations;
    gridManager = new GridManager(GridGenerator.generateGrid(path));
  }

  public void run() throws InterruptedException {
    for (double i = 0.0; i < iterations; i++) {
      gridManager.displayGrid();
      gridManager.updateGrid();
      gridManager.expandGrid();
      Thread.sleep(150);
      clearScreen();
    }
  }

  private static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}
