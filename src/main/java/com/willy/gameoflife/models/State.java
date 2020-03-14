package com.willy.gameoflife.models;

public enum State {
    ALIVE('O'), DEAD('.');
    public final char label;

    State(char label) {
        this.label = label;
    }
}
