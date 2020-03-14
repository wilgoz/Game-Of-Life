package com.willy.gameoflife.utils;

import com.willy.gameoflife.models.Cell;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Set;

public class CellGeneratorTest {

    private static final String FILE = "src/test/java/resources/glider.txt";

    @Test
    public void testGenerateCellsGeneratesProperCellFormations() throws IOException {
        Set<Cell> cells = CellGenerator.generateCells(FILE);
        Set<Cell> expected = Set.of(
            new Cell(0, 1),
            new Cell(1, 2),
            new Cell(2, 0),
            new Cell(2, 1),
            new Cell(2, 2)
        );
        Assert.assertEquals(expected, cells);
    }
}
