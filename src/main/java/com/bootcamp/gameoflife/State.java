package com.bootcamp.gameoflife;

public enum State {
  ALIVE('O'), DEAD('.');
  public final char label;

  State(char label) {
    this.label = label;
  }
}
