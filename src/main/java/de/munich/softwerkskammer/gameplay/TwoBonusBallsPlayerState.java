package de.munich.softwerkskammer.gameplay;

import java.util.List;

import static de.munich.softwerkskammer.gameplay.FrameFactory.newStrikeWithBonus;

/**
 * The player made a strike in the last frame and received two bonus balls as a result. This state handles
 * these two bonus balls.
 */
public class TwoBonusBallsPlayerState extends PlayerState {
    private Integer firstBonusRoll = null;

    /**
     * @param frames The completed frames so far
     */
    protected TwoBonusBallsPlayerState(List<Frame> frames) {
        super(10, frames);
    }

    @Override
    public PlayerState roll(int pins) {
        assert pins >= 0 && pins <= 10;
        if (firstBonusRoll != null) {
            if (firstBonusRoll < 10) {
                // the player can knock down at most the number of remaining pins
                assert pins <= 10-firstBonusRoll;
            }
            return new GameOverPlayerState(extendFrames(newStrikeWithBonus(firstBonusRoll, pins)));
        } else {
            firstBonusRoll = pins;
            return this;
        }
    }

    @Override
    public String toString() {
        return (firstBonusRoll != null ? "Second" : "First") + " of two bonus balls in the last frame";
    }
}
