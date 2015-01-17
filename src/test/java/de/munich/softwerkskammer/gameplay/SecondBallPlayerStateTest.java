package de.munich.softwerkskammer.gameplay;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;
import static de.munich.softwerkskammer.gameplay.FrameFactory.*;

public class SecondBallPlayerStateTest {
    @Test
    public void normal() {
        PlayerState initial = new SecondBallPlayerState(1, Collections.<Frame>emptyList(), 2);
        assertEquals(1, initial.getCurrentFrameNumber());
        PlayerState next = initial.roll(3);
        assertEquals(2, next.getCurrentFrameNumber());
    }

    @Test(expected = AssertionError.class)
    public void invalidPins() {
        new SecondBallPlayerState(1, Collections.<Frame>emptyList(), 10);
    }

    @Test(expected = AssertionError.class)
    public void tooManyPins() {
        new SecondBallPlayerState(1, Collections.<Frame>emptyList(), 4).roll(8);
    }

    @Test
    public void spare() {
        PlayerState state = new SecondBallPlayerState(1, Collections.<Frame>emptyList(), 4);
        PlayerState next = state.roll(6);
        assertEquals(2, next.getCurrentFrameNumber());
    }

    @Test
    public void spareInTheLastFrame() {
        PlayerState state = new SecondBallPlayerState(10, Collections.<Frame>emptyList(), 4);
        PlayerState next = state.roll(6);
        assertEquals(10, next.getCurrentFrameNumber());
    }

    @Test
    public void gameOver() {
        PlayerState initial = new SecondBallPlayerState(10, Arrays.asList(newStrike(1), newStrike(2), newStrike(3), newStrike(4), newStrike(5), newStrike(6), newStrike(7), newStrike(8), newStrike(9)), 2);
        PlayerState next = initial.roll(3);
        assertFalse(next.hasMoreBalls());
    }
}
