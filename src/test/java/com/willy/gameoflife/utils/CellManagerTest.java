package com.willy.gameoflife.utils;

import com.willy.gameoflife.models.Cell;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CellManagerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private Set<Cell> glider;

    @Before
    public void initGlider() {
        glider = new HashSet<>(
            Arrays.asList(
                new Cell(0, 1),
                new Cell(1, 2),
                new Cell(2, 0),
                new Cell(2, 1),
                new Cell(2, 2)
            )
        );
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    private CellManager initCellManager() {
        var cellManager = new CellManager(glider);
        cellManager.computeBounds();
        return cellManager;
    }

    @Test
    public void testComputeBoundsComputesMinX() throws NoSuchFieldException, IllegalAccessException {
        var cellManager = new CellManager(glider);
        cellManager.computeBounds();
        Field field = CellManager.class.getDeclaredField("minX");
        field.setAccessible(true);
        Assert.assertEquals(0, field.get(cellManager));
    }

    @Test
    public void testComputeBoundsComputesMaxX() throws NoSuchFieldException, IllegalAccessException {
        var cellManager = new CellManager(glider);
        cellManager.computeBounds();
        Field field = CellManager.class.getDeclaredField("maxX");
        field.setAccessible(true);
        Assert.assertEquals(2, field.get(cellManager));
    }

    @Test
    public void testComputeBoundsComputesMinY() throws NoSuchFieldException, IllegalAccessException {
        var cellManager = new CellManager(glider);
        cellManager.computeBounds();
        Field field = CellManager.class.getDeclaredField("minY");
        field.setAccessible(true);
        Assert.assertEquals(0, field.get(cellManager));
    }

    @Test
    public void testComputeBoundsComputesMaxY() throws NoSuchFieldException, IllegalAccessException {
        var cellManager = new CellManager(glider);
        cellManager.computeBounds();
        Field field = CellManager.class.getDeclaredField("maxY");
        field.setAccessible(true);
        Assert.assertEquals(2, field.get(cellManager));
    }

    @Test
    public void givenCellFileDisplayCellsDisplaysCorrectCellFormations() {
        var cellManager = initCellManager();
        String expected = ""
            + ". . . . . \n"
            + ". . O . . \n"
            + ". . . O . \n"
            + ". O O O . \n"
            + ". . . . . \n";
        cellManager.displayCells();
        Assert.assertEquals(expected, outContent.toString());
    }

    @Test
    public void givenCellFileUpdateCellsUpdatesTheCellFormations() {
        var cellManager = initCellManager();
        String expected = ""
            + ". . . . . \n"
            + ". . . . . \n"
            + ". O . O . \n"
            + ". . O O . \n"
            + ". . O . . \n"
            + ". . . . . \n";
        cellManager.updateCells();
        cellManager.computeBounds();
        cellManager.displayCells();
        Assert.assertEquals(expected, outContent.toString());
    }
}
