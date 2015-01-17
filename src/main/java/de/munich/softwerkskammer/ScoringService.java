package de.munich.softwerkskammer;

import de.munich.softwerkskammer.gameplay.Frame;

import java.util.List;

/**
 * Compute the score of a player. Also supports incomplete games.
 */
public class ScoringService {
    private final List<Frame> frames;
    private final List<Integer> rolls;

    public ScoringService(List<Frame> frames, List<Integer> rolls) {
        this.frames = frames;
        this.rolls = rolls;
    }

    public int computeScore() {
        if (frames.isEmpty()) {
            return 0;
        }
        int result = 0;
        int rollIndex = 0;
        for (Frame frame : frames) {
            result += frame.computeScore(rolls, rollIndex);
            rollIndex += frame.getNumberOfBalls();
        }

        // game is in progress and we have some remaining frames
        for (int i=rollIndex; i < rolls.size(); i++) {
            result += rolls.get(i);
        }

        return result;
    }
}
