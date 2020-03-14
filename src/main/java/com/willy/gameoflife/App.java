package com.willy.gameoflife;

import com.willy.gameoflife.utils.GameOfLife;

import java.io.IOException;

public class App {

    private static final String PREAMBLE = "src/main/java/resources/";
    private static final String DEFAULT_CFG = "glider-gun.txt";
    private static final int DELAY = 150;

    public static void main(String[] args) throws IOException, InterruptedException {
        var file = args.length == 0 ? DEFAULT_CFG : args[0];
        var game = new GameOfLife(PREAMBLE + file, Integer.MAX_VALUE, DELAY);
        game.run();
    }
}
