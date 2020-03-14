package com.willy.gameoflife.utils;

import java.io.IOException;

public class GameOfLife {

    private CellManager cellManager;
    private int iterations;
    private int delay;

    public GameOfLife(String path, int iterations, int delay) throws IOException {
        this.iterations = iterations;
        this.delay = delay;
        cellManager = new CellManager(CellGenerator.generateCells(path));
    }

    public void run() throws InterruptedException {
        for (int i = 1; i <= iterations; i++) {
            cellManager.computeBounds();
            cellManager.displayCells();
            cellManager.updateCells();
            Thread.sleep(delay);
            clearScreen();
        }
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
