package com.bootcamp.gameoflife;

import java.io.FileNotFoundException;

public class App {

  private static final String PREAMBLE = "src/main/java/assets/";
  private static final String CELL_CFG = "glider-gun.txt";

  public static void main(String[] args) throws FileNotFoundException, InterruptedException {
    var game = new GameOfLife(PREAMBLE + CELL_CFG, Double.POSITIVE_INFINITY, 150);
    game.run();
  }
}
