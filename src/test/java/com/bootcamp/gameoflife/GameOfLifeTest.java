package com.bootcamp.gameoflife;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameOfLifeTest {

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
  public void testRunOutputsGrid() throws FileNotFoundException, InterruptedException {
    var game = new GameOfLife(PREAMBLE + "glider.txt", 1);
    String expected = ""
        + ". O . . . . \n"
        + ". . O . . . \n"
        + "O O O . . . \n"
        + ". . . . . . \n"
        + ". . . . . . \n"
        + "\033[H\033[2J";
    game.run();
    Assert.assertEquals(expected, outContent.toString());
  }
}
