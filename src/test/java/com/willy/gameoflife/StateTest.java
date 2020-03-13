package com.willy.gameoflife;

import org.junit.Assert;
import org.junit.Test;

public class StateTest {

    @Test
    public void testLabelIfAliveReturnAlive() {
        State state = State.ALIVE;
        Assert.assertEquals(State.ALIVE.label, state.label);
    }

    @Test
    public void testLabelIfDeadReturnDead() {
        State state = State.DEAD;
        Assert.assertEquals(State.DEAD.label, state.label);
    }
}
