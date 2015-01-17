package de.munich.softwerkskammer.gameplay;

import java.util.List;

import static de.munich.softwerkskammer.gameplay.FrameFactory.newFrame;

/**
 * The state of the game for a player after a ball was already rolled and there are remaining pins to knock down.
 */
public class SecondBallPlayerState extends PlayerState {
    private final int firstRoll;

    protected SecondBallPlayerState(int currentFrameNumber, List<Frame> frames, int firstRoll) {
        super(currentFrameNumber, frames);
        assert firstRoll < 10;
        this.firstRoll = firstRoll;
    }

    @Override
    public PlayerState roll(int pins) {
        assert pins >= 0 && pins <= 10 - firstRoll;

        if (isLastFrame()) {
            if (firstRoll + pins == 10) {
                return new OneBonusBallPlayerState(frames, firstRoll, pins);
            } else {
                return new GameOverPlayerState(extendFrames(newFrame(currentFrameNumber, firstRoll, pins)));
            }
        } else {
            return new FirstBallPlayerState(currentFrameNumber + 1, extendFrames(newFrame(currentFrameNumber, firstRoll, pins)));
        }
    }

    @Override
    public String toString() {
        return "Second ball of frame " + currentFrameNumber;
    }
}
