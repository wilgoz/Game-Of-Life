package com.bootcamp.gameoflife;

import java.io.FileNotFoundException;

public class GameOfLife {

  private GridManager gridManager;
  private double iterations;
  private int delay;

  public GameOfLife(String path, double iterations, int delay) throws FileNotFoundException {
    this.iterations = iterations;
    this.delay = delay;
    gridManager = new GridManager(GridGenerator.generateGrid(path));
  }

  public void run() throws InterruptedException {
    for (double i = 0.0; i < iterations; i++) {
      gridManager.displayGrid();
      gridManager.updateGrid();
      gridManager.expandGrid();
      Thread.sleep(delay);
      clearScreen();
    }
  }

  private static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}
