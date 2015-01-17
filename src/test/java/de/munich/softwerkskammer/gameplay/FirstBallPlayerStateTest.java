package de.munich.softwerkskammer.gameplay;

import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;

public class FirstBallPlayerStateTest {
    @Test
    public void normal() {
        PlayerState initial = new FirstBallPlayerState(1, Collections.<Frame>emptyList());
        assertTrue(initial.hasMoreBalls());
        assertEquals(1, initial.getCurrentFrameNumber());
        PlayerState next = initial.roll(1);
        assertTrue(next.hasMoreBalls());
        assertEquals(next.getCurrentFrameNumber(), initial.getCurrentFrameNumber());
        PlayerState next2 = next.roll(2);
        assertTrue(next2.hasMoreBalls());
        assertEquals(2, next2.getCurrentFrameNumber());
    }

    @Test(expected = AssertionError.class)
    public void invalidPins() {
        new FirstBallPlayerState(1, Collections.<Frame>emptyList()).roll(11);
    }

    @Test(expected = AssertionError.class)
    public void tooManyPins() {
        new FirstBallPlayerState(1, Collections.<Frame>emptyList()).roll(4).roll(8);
    }

    @Test
    public void strike() {
        PlayerState state = new FirstBallPlayerState(1, Collections.<Frame>emptyList());
        PlayerState next = state.roll(10);
        assertEquals(2, next.getCurrentFrameNumber());
    }

    @Test
    public void strikeInTheLastFrame() {
        PlayerState state = new FirstBallPlayerState(10, Collections.<Frame>emptyList());
        PlayerState next = state.roll(10);
        assertEquals(10, next.getCurrentFrameNumber());
    }
}
