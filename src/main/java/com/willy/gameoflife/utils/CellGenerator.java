package com.willy.gameoflife.utils;

import com.willy.gameoflife.models.Cell;
import com.willy.gameoflife.models.State;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class CellGenerator {

    private static final int HASH_SIZE = 8192;

    private CellGenerator() {
    }

    public static Set<Cell> generateCells(String file) throws IOException {
        try (var reader = new BufferedReader(new FileReader(file))) {
            Set<Cell> cells = new HashSet<>(HASH_SIZE);
            var ref = new Object() {
                String line;
                int row;
            };
            while ((ref.line = reader.readLine()) != null) {
                IntStream.range(0, ref.line.length())
                    .filter(index -> ref.line.charAt(index) == State.ALIVE.label)
                    .mapToObj(col -> new Cell(ref.row, col))
                    .forEach(cells::add);
                ref.row++;
            }
            return cells;
        }
    }
}
