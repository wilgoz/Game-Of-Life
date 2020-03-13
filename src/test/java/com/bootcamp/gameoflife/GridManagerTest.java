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

  private GridManager initGridManager(String file) throws FileNotFoundException {
    var grid = GridGenerator.generateGrid(file);
    return new GridManager(grid);
  }

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
    var gridManager = initGridManager(PREAMBLE + "glider.txt");
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
    var gridManager = initGridManager(PREAMBLE + "glider.txt");
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

  @Test
  public void givenCellThatTouchesBottomMostRowExpandGridShouldExpandBottomRow()
      throws FileNotFoundException {
    var gridManager = initGridManager(PREAMBLE + "glider-expand-bottom.txt");
    String expected = ""
        + ". . . . . . . . . . . . . . \n"
        + ". . . . . . . . . . . . . . \n"
        + ". . . . . . . . . . . . . . \n"
        + ". . . . O . O . . . . . . . \n"
        + ". . . . . O O . . . . . . . \n"
        + ". . . . . O . . . . . . . . \n"
        + ". . . . . . . . . . . . . . \n";
    for (int i = 0; i < 5; i++) {
      gridManager.updateGrid();
      gridManager.expandGrid();
    }
    gridManager.displayGrid();
    Assert.assertEquals(expected, outContent.toString());
  }

  @Test
  public void givenCellThatTouchesTopMostRowExpandGridShouldExpandTopRow()
      throws FileNotFoundException {
    var gridManager = initGridManager(PREAMBLE + "glider-expand-top.txt");
    String expected = ""
        + ". . . . . . . . . . . . . . . . . . . . . . . . . . . . . \n"
        + ". . . . . . . . . . . . . O O . . . . . . . . . . . . . . \n"
        + ". . . . . . . . . . . . . O . O . . . . . . . . . . . . . \n"
        + ". . . . . . . . . . . . . O . . . . . . . . . . . . . . . \n"
        + ". . . . . . . . . . . . . . . . . . . . . . . . . . . . . \n";
    for (int i = 0; i < 2; i++) {
      gridManager.updateGrid();
      gridManager.expandGrid();
    }
    gridManager.displayGrid();
    Assert.assertEquals(expected, outContent.toString());
  }
}
