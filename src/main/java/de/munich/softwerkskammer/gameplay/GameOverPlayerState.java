package de.munich.softwerkskammer.gameplay;

import java.util.List;

/**
 * The game has finished for the player and he cannot roll any more balls.
 */
public class GameOverPlayerState extends PlayerState {
    protected GameOverPlayerState(List<Frame> frames) {
        super(-1, frames);
        assert frames.size() == 10;
    }

    @Override
    public PlayerState roll(int pins) {
        throw new IllegalStateException("Game over");
    }

    @Override
    public boolean hasMoreBalls() {
        return false;
    }

    @Override
    public String toString() {
        return "Game over";
    }
}
