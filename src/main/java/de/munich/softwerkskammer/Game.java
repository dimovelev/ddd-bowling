package de.munich.softwerkskammer;

import de.munich.softwerkskammer.gameplay.PlayerState;

import java.util.ArrayList;
import java.util.List;
import static de.munich.softwerkskammer.gameplay.PlayerStateFactory.*;

public class Game {
    private List<Integer> rolls = new ArrayList<>(21);
    private PlayerState state = start();

    public void roll(int pins) {
        state = state.roll(pins);
        rolls.add(pins);
    }

    public int score() {
        return new ScoringService(state.getCompletedFrames(), rolls).computeScore();
    }

    public PlayerState start() {
        return newInitialPlayerState();
    }
}