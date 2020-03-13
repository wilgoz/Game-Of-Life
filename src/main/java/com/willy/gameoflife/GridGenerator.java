package com.willy.gameoflife;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GridGenerator {

    private GridGenerator() {
    }

    public static Grid generateGrid(String file) throws FileNotFoundException {
        Set<Cell> cells = new HashSet<>();
        int rows = 0;
        int cols = 0;
        try (Scanner scanner = new Scanner(new File(file))) {
            while (scanner.hasNextLine()) {
                cols = 0;
                for (char c : scanner.nextLine().toCharArray()) {
                    if (c == State.ALIVE.label) {
                        cells.add(new Cell(rows, cols));
                    }
                    cols++;
                }
                rows++;
            }
            return new Grid(cells, rows, cols);
        }
    }
}
