package com.bootcamp.gameoflife;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GridManagerTest {

  private static final String PREAMBLE = "src/main/java/assets/";

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @After
  public void restoreStreams() {
    System.setOut(originalOut);
  }

  @Test
  public void givenCellFileDisplayGridDisplaysCorrectCellFormations() throws FileNotFoundException {
    var grid = GridGenerator.generateGrid(PREAMBLE + "glider.txt");
    var gridManager = new GridManager(grid);
    String expected = ""
        + ". O . . . . \n"
        + ". . O . . . \n"
        + "O O O . . . \n"
        + ". . . . . . \n"
        + ". . . . . . \n";
    gridManager.displayGrid();
    Assert.assertEquals(expected, outContent.toString());
  }
  @Test
  public void givenCellFileUpdateGridUpdatesTheCellFormations() throws FileNotFoundException {
    var grid = GridGenerator.generateGrid(PREAMBLE + "glider.txt");
    var gridManager = new GridManager(grid);
    String expected = ""
        + ". . . . . . \n"
        + "O . O . . . \n"
        + ". O O . . . \n"
        + ". O . . . . \n"
        + ". . . . . . \n";
    gridManager.updateGrid();
    gridManager.displayGrid();
    Assert.assertEquals(expected, outContent.toString());
  }
}
