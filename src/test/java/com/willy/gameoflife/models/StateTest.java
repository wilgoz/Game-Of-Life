package com.willy.gameoflife.models;

import org.junit.Assert;
import org.junit.Test;

public class StateTest {

    @Test
    public void testAliveReturnsAliveLabel() {
        Assert.assertEquals('O', State.ALIVE.label);
    }

    @Test
    public void testDeadReturnsDeadLabel() {
        Assert.assertEquals('.', State.DEAD.label);
    }
}
