package de.munich.softwerkskammer.gameplay;

import java.util.List;

import static de.munich.softwerkskammer.gameplay.FrameFactory.newStrike;

/**
 * The initial state of a frame - all 10 pins are still there and the player is supposed to roll a boll and try to knock
 * them down.
 */
public class FirstBallPlayerState extends PlayerState {
    protected FirstBallPlayerState(int currentFrameNumber, List<Frame> frames) {
        super(currentFrameNumber, frames);
    }

    @Override
    public PlayerState roll(int pins) {
        assert pins >= 0 && pins <= 10;
        if (pins == 10) {
            if (isLastFrame()) {
                return new TwoBonusBallsPlayerState(frames);
            } else {
                return new FirstBallPlayerState(currentFrameNumber + 1, extendFrames(newStrike(currentFrameNumber)));
            }
        } else {
            return new SecondBallPlayerState(currentFrameNumber, frames, pins);
        }
    }

    @Override
    public String toString() {
        return "First ball of frame " + currentFrameNumber;
    }
}
